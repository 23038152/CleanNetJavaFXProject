package com.example.ja;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernameField; // Tekstveld waar de gebruiker zijn gebruikersnaam invoert
    @FXML
    private PasswordField passwordField; // Tekstveld waar de gebruiker zijn wachtwoord invoert

    @FXML
    private void onLoginButtonClick(ActionEvent event) {
        // Haal de ingevoerde gebruikersnaam en wachtwoord op
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Controleer of de ingevoerde gegevens overeenkomen met admin-credentials of een databasegebruiker
        if (admin(username, password) || authenticate(username, password)) {
            System.out.println("Login successful!");
            try {
                // Laad de HomePage.fxml-view
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent root = loader.load();

                // Haal de controller van de nieuwe pagina op (indien nodig voor logica)
                HomePageController controller = loader.getController();

                // Verkrijg het huidige venster en stel de nieuwe scene in
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e){
                // Print een foutmelding als er iets misgaat bij het laden van de nieuwe pagina
                e.printStackTrace();
            }
        } else {
            // Toon een foutmelding als de login niet succesvol is
            System.out.println("Login failed!");
        }
    }

    // Controleer of de ingevoerde gegevens overeenkomen met de standaard admin-credentials
    public boolean admin(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            return true; // Admin-login succesvol
        }
        else return false; // Admin-login niet succesvol
    }

    // Controleer of de ingevoerde gegevens overeenkomen met een gebruiker in de database
    public boolean authenticate(String username, String password) {
        // Databaseverbinding gegevens
        String url = "jdbc:mysql://localhost:3306/cleannet";
        String dbUsername = "root";
        String dbPassword = "bombo";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            // SQL-query om gebruikersnaam en wachtwoord te valideren
            String sql = "SELECT * FROM Gebruiker WHERE username = ? AND wachtwoord = ?";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Voer de query uit en controleer of er resultaten zijn
            var resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // True als een gebruiker wordt gevonden
        } catch (SQLException e) {
            // Print een foutmelding als er een probleem is met de databaseverbinding
            e.printStackTrace();
            return false; // Retourneer false bij een fout
        }
    }

}