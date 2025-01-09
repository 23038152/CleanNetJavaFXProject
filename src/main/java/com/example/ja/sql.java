package com.example.ja;

import java.sql.*;


public class sql {

    // Database configuratie
    // static is dat je het overal in de class kan gebruiken
    // final is dat je het niet kan veranderen
    private static final String URL = "jdbc:mysql://localhost:3306/cleannet";
    private static final String USERNAME = "root"; // Gebruikersnaam voor de database
    private static final String PASSWORD = "bombo"; // Wachtwoord voor de database

    // Methode om alle gebruikersgegevens op te halen uit de database
    public static void query() {
        // Probeert verbinding te maken met de database
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Verbonden met de database!");

            // SQL-query om alle gebruikersgegevens op te halen
            String sql = "SELECT * FROM Gebruiker";
            // Probeer de query uit te voeren en het resultaat op te halen
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // Doorloop het resultaat en druk de gegevens af
                while (resultSet.next()) {
                    int id = resultSet.getInt("gebruikerID");
                    String userName = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    System.out.println("ID: " + id + ", Gebruikersnaam: " + userName + ", Email: " + email);
                }
            }
        } catch (SQLException e) {
            // Foutafhandeling als de verbinding mislukt
            System.err.println("❌ Fout bij verbinden met de database!");
            e.printStackTrace();
        }
    }

    // Methode om gegevens van een sensor op te halen
    public static void readSensorStatus() {
        // Probeert verbinding te maken met de database
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Verbonden met de database!");

            // SQL-query om sensorgegevens op te halen
            String sql = "SELECT * FROM sensor";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // Doorloop het resultaat en druk de gegevens af
                while (resultSet.next()) {
                    int sensorId = resultSet.getInt("sensorId");
                    String status = resultSet.getString("status");
                    String timestamp = resultSet.getString("timestamp");
                    System.out.println("Sensor ID: " + sensorId + ", Status: " + status + ", Timestamp: " + timestamp);
                }
            }
        } catch (SQLException e) {
            // Foutafhandeling als de verbinding mislukt
            System.err.println("❌ Fout bij verbinden met de database!");
            e.printStackTrace();
        }
    }

    // Methode om de status van een bestaande sensor bij te werken
    public static void updateSensorStatus(int sensorId, String status) {
        // Probeert verbinding te maken met de database
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Verbonden met de database!");

            // SQL-query om de status van een sensor bij te werken
            String sql = "UPDATE sensor SET status = ?, timestamp = NOW() WHERE sensorId = ?";
            // Probeert de query uit te voeren en de status bij te werken
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, status); // Stel de nieuwe status in
                pstmt.setInt(2, sensorId); // Geef het ID van de sensor door
                int rowsUpdated = pstmt.executeUpdate(); // Voer de update uit
                if (rowsUpdated > 0) {
                    // Controleer of er rijen zijn bijgewerkt
                    System.out.println("✅ Status succesvol bijgewerkt voor sensor ID: " + sensorId);
                } else {
                    // Geef een waarschuwing als de sensor niet is gevonden
                    System.out.println("⚠️ Geen sensor gevonden met ID: " + sensorId);
                }
            }
        } catch (SQLException e) {
            // Foutafhandeling als de verbinding mislukt
            System.err.println("❌ Fout bij databaseverbinding!");
            e.printStackTrace();
        }
    }

    // Main-methode om de functionaliteiten te testen
    public static void main(String[] args) {
        query(); // Haal gebruikersgegevens op
        readSensorStatus(); // Haal de status van de sensor op
        updateSensorStatus(1, "Vol"); // Werk de status van een bestaande sensor bij
    }
}
