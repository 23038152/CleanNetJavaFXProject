package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AboutUsController {

    // Methode voor de About Us knop
    @FXML
    public void handleButtonClickHomepage(MouseEvent event) {
        try {
            // Laad de About Us pagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
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
            // Laad de Webshop pagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Webshop.fxml"));
            Scene webshopScene = new Scene(fxmlLoader.load());

            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(webshopScene);
            stage.setTitle("Homepage");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}