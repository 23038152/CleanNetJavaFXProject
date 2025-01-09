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
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (admin(username, password) || authenticate(username, password)) {
            System.out.println("Login successful!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent root = loader.load();

                HomePageController controller = loader.getController();

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Login failed!");
        }
    }

    public boolean admin(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            return true;
        }
        else return false;
    }

    public boolean authenticate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/cleannet";
        String dbUsername = "root";
        String dbPassword = "bombo";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM Gebruiker WHERE username = ? AND wachtwoord = ?";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // True als een gebruiker wordt gevonden
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}