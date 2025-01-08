package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox; // Zorg dat dit erbij staat!
import java.io.IOException;

public class WebshopController {

    @FXML
    private ComboBox<String> priceComboBox;

    @FXML
    public void initialize() {
        priceComboBox.getItems().addAll("1 sensor €49,99", "2 sensors €99,98", "3 sensors €149,69", "4 sensors €199,-");
        priceComboBox.setPromptText("Kies een prijs");
    }

    // Methode voor de About Us knop
    @FXML
    public void handleButtonClickAboutUs(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/AboutUS.fxml"));
            Scene aboutUsScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(aboutUsScene);
            stage.setTitle("About Us");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode voor de System Notifs knop
    @FXML
    public void handleButtonClickNotifs (MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/MaintenancePage.fxml"));
            Scene notifsScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(notifsScene);
            stage.setTitle("Maintenance Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode voor de Homepage knop
    @FXML
    public void handleButtonClickHomePage(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
            Scene webshopScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(webshopScene);
            stage.setTitle("Homepage");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}