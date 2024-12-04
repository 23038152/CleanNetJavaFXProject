package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;

public class HomePageController {
    @FXML
    private Button SystemNotifs;  // De naam moet overeenkomen met de fx:id in de FXML
    @FXML
    private Button aboutusButton;  // De naam moet overeenkomen met de fx:id in de FXML
    @FXML
    private Button webshopButton;  // De naam moet overeenkomen met de fx:id in de FXML

    // Actie voor de notificatieknop
    @FXML
    public void handleButtonClickNotifs(ActionEvent event) {
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

    // Actie voor de 'About Us' knop
    @FXML
    public void handleButtonClickAboutus(ActionEvent event) {
        try {
            // Laad de About Us pagina FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/AboutUsPage.fxml"));
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

    // Actie voor de 'Webshop' knop
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
}