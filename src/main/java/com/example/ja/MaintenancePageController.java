package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import java.io.IOException;

public class MaintenancePageController {

    @FXML
    private TitledPane maintenanceTitledPane;

    @FXML
    private Label infoLabel;

    @FXML
    public void initialize() {
        // TitledPane standaard gesloten instellen
        if (maintenanceTitledPane != null) {
            maintenanceTitledPane.setExpanded(false);

            // Dynamisch openen/sluiten met een klik
            maintenanceTitledPane.setOnMouseClicked(event -> {
                boolean isExpanded = maintenanceTitledPane.isExpanded();
                maintenanceTitledPane.setExpanded(!isExpanded);
            });
        }
    }

    // Methodes voor de navigatieknoppen
    @FXML
    public void handleButtonClickAboutUs(ActionEvent event) {
        try {
            // Laad de About Us pagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/AboutUS.fxml"));
            Scene aboutUsScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(aboutUsScene);
            stage.setTitle("About Us");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleButtonClickWebshop(ActionEvent event) {
        try {
            // Laad de Webshop pagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/WebshopPage.fxml"));
            Scene webshopScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(webshopScene);
            stage.setTitle("Webshop");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleButtonClickHomepage(ActionEvent event) {
        try {
            // Laad de HomePage FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
            Scene homeScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeScene);
            stage.setTitle("Home Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}