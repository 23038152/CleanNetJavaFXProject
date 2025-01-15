package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label; // Voor het Label
import javafx.scene.control.Button; // Voor de Koop-knop
import javafx.animation.PauseTransition; // Voor vertraging
import javafx.util.Duration; // Voor de duur van de vertraging
import java.io.IOException;

public class WebshopController {

    @FXML
    private ComboBox<String> priceComboBox;

    @FXML
    private Button koopButton; // Zorg ervoor dat de fx:id in FXML klopt!

    @FXML
    private Label winkelmandjeLabel; // Zorg ervoor dat de fx:id in FXML klopt!

    @FXML
    public void initialize() {
        priceComboBox.getItems().addAll("1 sensor €49,99", "2 sensors €99,98");
        priceComboBox.setPromptText("Kies een prijs");
    }

    // Methode voor de Koop-knop
    @FXML
    private void handleKoopButtonClick() {
        winkelmandjeLabel.setText("Toegevoegd aan winkelmandje!");

        // Tekst na 3 seconden laten verdwijnen
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> winkelmandjeLabel.setText(""));
        pause.play();
    }

    // Methode voor de Homepage-knop
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