package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsController {

    // Methode voor de Homepage knop
    @FXML
    public void handleButtonClickHomepage(MouseEvent event) {
        try {
            // Laad de Notificatiepagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
            Scene notifsScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(notifsScene);
            stage.setTitle("Homepage");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode voor de System Notifs knop
    @FXML
    public void handleButtonClickNotifs(MouseEvent event) {
        try {
            // Laad de Notificatiepagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/MaintenancePage.fxml"));
            Scene notifsScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
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
    public void handleButtonClickWebshop(MouseEvent event) {
        try {
            // Laad de Notificatiepagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Webshop.fxml"));
            Scene notifsScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(notifsScene);
            stage.setTitle("Homepage");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label infoLabel;

    @FXML
    protected void onAboutUs() {
        infoLabel.setText("Welkom bij de About Us pagina!");
    }
}
