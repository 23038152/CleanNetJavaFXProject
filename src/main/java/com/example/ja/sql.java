package com.example.ja;

import java.sql.*;

public class sql {

    // Database configuratie
    // static is dat je het overal in de class kan gebruiken
    // final is dat je het niet kan veranderen
    private static final String URL = "jdbc:mysql://localhost:3306/cleannet";
    private static final String USERNAME = "root"; // Gebruikersnaam voor de database
    private static final String PASSWORD = "bombo"; // Wachtwoord voor de database

    // Methode om de status van een sensor op te halen op basis van sensor ID
    public static String getSensorStatusById(int sensorId) {
        String sql = "SELECT status FROM sensor WHERE sensorId = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, sensorId); // Stel het sensor ID in
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("status"); // Haal de status op
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Foutafhandeling bij SQL-query
        }
        return null; // Retourneer null als er geen resultaat is
    }


    // Main-methode om de functionaliteiten te testen
    public static void main(String[] args) {
    }
}
