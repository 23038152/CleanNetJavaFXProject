package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class MaintenancePageController {

    @FXML
    private ImageView AboutusButton;

    @FXML
    private ImageView WebshopButton;

    @FXML
    private ImageView HomepageButton;

    @FXML
    public void initialize() {
        // Deze methode wordt aangeroepen zodra de controller is geïnitieerd
        // Voeg hier eventueel extra initialisatie toe
    }

    // Methode voor de Home knop
    @FXML
    public void handleButtonClickHomepage() {
        try {
            // Laad de HomePage FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
            Scene homeScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) HomepageButton.getScene().getWindow();
            stage.setScene(homeScene);
            stage.setTitle("Home Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}