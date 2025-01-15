package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MaintenancePageController {

    @FXML
    private ImageView HomepageButton;

    @FXML
    private Label sensorStatusLabel;
    private Timeline timeline;

    @FXML
    public void initialize() {
        // Start het laden van de sensorstatus met een interval
        startSensorStatusUpdater(1); // Vervang '1' door het gewenste sensor-ID
    }

    // Methode om de status automatisch bij te werken
    private void startSensorStatusUpdater(int sensorId) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> loadSensorStatus(sensorId)));
        timeline.setCycleCount(Timeline.INDEFINITE); // Zorg dat de update oneindig blijft draaien
        timeline.play(); // Start de timeline
    }

    // Methode om de sensorstatus te laden
    private void loadSensorStatus(int sensorId) {
        try {
            String status = sql.getSensorStatusById(sensorId);
            if (status != null) {
                sensorStatusLabel.setText(status);
            } else {
                sensorStatusLabel.setText("Status: niet beschikbaar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sensorStatusLabel.setText("Status: fout bij laden");
        }
    }

    // Methode voor de Home knop
    @FXML
    public void handleButtonClickHomepage() {
        try {
            // Laad de HomePage FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/Homepage.fxml"));
            Scene homeScene = new Scene(fxmlLoader.load());

            stopSensorStatusUpdater();
            // Haal het huidige venster op en wijzig de scene
            Stage stage = (Stage) HomepageButton.getScene().getWindow();
            stage.setScene(homeScene);
            stage.setTitle("Home Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void stopSensorStatusUpdater() {
        if (timeline != null) {
            timeline.stop();
        }
    }

}