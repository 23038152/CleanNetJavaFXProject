package com.example.ja;

import com.fazecast.jSerialComm.SerialPort;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Klasse die gegevens verwerkt van een seriële poort en deze opslaat in een database
public class SerialDatabaseHandler {

    // Database configuratie
    // static is dat je het overal in de class kan gebruiken
    // final is dat je het niet kan veranderen
    private static final String URL = "jdbc:mysql://localhost:3306/cleannet"; // URL van de database
    private static final String USERNAME = "root"; // Gebruikersnaam voor de database
    private static final String PASSWORD = "bombo"; // Wachtwoord voor de database

    private SerialPort serialPort; // Seriële poort voor communicatie
    private StringBuilder tempBuffer; // Buffer voor tijdelijke opslag van inkomende data

    // Constructor voor het initialiseren van de seriële poort en buffer
    public SerialDatabaseHandler(String portName, int baudRate) {
        serialPort = SerialPort.getCommPort(portName); // Stel de seriële poort in
        serialPort.setBaudRate(baudRate); // Stel de baudrate in
        tempBuffer = new StringBuilder(); // Initialiseer de tijdelijke buffer
    }

    // Methode om verbinding te maken met de seriële poort
    public boolean connectSerialPort() {
        if (serialPort.openPort()) { // Controleer of de poort kan worden geopend
            System.out.println("✅ Verbonden met de Arduino!"); // Bevestiging van verbinding
            return true;
        }
        System.err.println("❌ Kan geen verbinding maken met de seriële poort."); // Foutmelding
        return false;
    }

    // Methode om verbinding te maken met de database en ontvangen data te verwerken
    public boolean connectDatabaseAndProcessData() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Verbonden met de database!"); // Bevestiging van verbinding
            byte[] buffer = new byte[1024]; // Buffer om inkomende data op te slaan in max 1024 bytes per keer

            while (serialPort.isOpen()) { // Blijf data lezen zolang de poort open is
                int numBytes = serialPort.readBytes(buffer, buffer.length); // Lees data van de seriële poort
                if (numBytes > 0) { // Controleer of data is ontvangen
                    tempBuffer.append(new String(buffer, 0, numBytes)); // Voeg ontvangen data toe aan buffer

                    int newlineIndex = tempBuffer.indexOf("\n"); // Zoek naar een nieuwe lijn in de buffer
                    while (newlineIndex != -1) { // Verwerk berichten totdat er geen nieuwe lijn meer is
                        String completeMessage = tempBuffer.substring(0, newlineIndex).trim(); // Haal een volledig bericht op
                        tempBuffer.delete(0, newlineIndex + 1); // Verwijder verwerkt bericht uit buffer

                        System.out.println("Ontvangen volledig bericht: [" + completeMessage + "]");

                        // Controleer of het bericht geldig is
                        if ("Vol".equals(completeMessage) || "Niet vol".equals(completeMessage)) {
                            updateSensorStatus(connection, completeMessage, 1); // Verwerk geldig bericht
                        } else {
                            System.err.println("❌ Ongeldig bericht ontvangen: [" + completeMessage + "]"); // Ongeldig bericht
                        }

                        newlineIndex = tempBuffer.indexOf("\n"); // Zoek naar het volgende bericht
                    }
                }
            }
        } catch (SQLException e) {
            // Foutafhandeling bij het verbinden met de database
            System.err.println("❌ Fout bij databaseverbinding!");
            e.printStackTrace();
            return false; // Terugkeren als er een fout optreedt
        }
        return true; // Bevestigen dat de verwerking succesvol is
    }

    // Methode om de status van een sensor in de database bij te werken
    private void updateSensorStatus(Connection connection, String status, int sensorId) {
        String updateSensorQuery = "UPDATE sensor SET status = ? WHERE sensorId = ?";
        String insertSensorUpdateQuery = "INSERT INTO SensorUpdate (sensorId, timestamp, status) VALUES (?, NOW(), ?)";

        try (PreparedStatement updateStmt = connection.prepareStatement(updateSensorQuery);
             PreparedStatement insertStmt = connection.prepareStatement(insertSensorUpdateQuery)) {

            // Update de status in de `sensor`-tabel
            updateStmt.setString(1, status);
            updateStmt.setInt(2, sensorId);
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✅ Sensorstatus succesvol bijgewerkt. Sensor ID: " + sensorId + ", Status: " + status);

                // Voeg een nieuwe regel toe in de `SensorUpdate`-tabel
                insertStmt.setInt(1, sensorId);
                insertStmt.setString(2, status);
                insertStmt.executeUpdate();
                System.out.println("✅ Sensorupdate succesvol toegevoegd aan `SensorUpdate`-tabel.");
            } else {
                System.err.println("⚠️ Geen sensor gevonden met ID: " + sensorId);
            }
        } catch (SQLException e) {
            System.err.println("❌ Fout bij het bijwerken van de sensorstatus!"); // Foutmelding
            e.printStackTrace();
        }
    }

    // Methode om de seriële poort te sluiten
    public void closeSerialPort() {
        if (serialPort.isOpen()) { // Controleer of de poort open is
            serialPort.closePort(); // Sluit de poort
            System.out.println("Seriële poort gesloten.");
        }
    }
}
