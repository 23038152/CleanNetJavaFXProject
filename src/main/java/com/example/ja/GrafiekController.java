package com.example.ja;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrafiekController {

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private ImageView HomepageButton;

    @FXML
    public void initialize() {
        // Configureer de assen
        configureAxes();

        // Stel marges in voor de grafiek
        lineChart.setPadding(new Insets(10, 10, 10, 10)); // Marges rondom de grafiek

        // Voeg data toe aan de grafiek
        loadData();
    }

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

    private void configureAxes() {
        // Configureer de y-as
        yAxis.setLabel("Status");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0); // "Niet vol"
        yAxis.setUpperBound(1.1); // Iets ruimte boven "Vol"
        yAxis.setTickUnit(1);

        // Voeg aangepaste labels toe voor de y-as
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis) {
            @Override
            public String toString(Number object) {
                if (object.doubleValue() == 0) return "Niet vol";
                if (object.doubleValue() == 1) return "Vol";
                return ""; // Geen label voor andere waarden
            }
        });

        // Configureer de x-as
        xAxis.setLabel("Tijd (minuten)");
        xAxis.setAutoRanging(true); // Laat de schaal van de x-as automatisch bepalen
    }


    private void loadData() {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Sensorstatus");

        String sql = "SELECT TIMESTAMPDIFF(MINUTE, (SELECT MIN(timestamp) FROM SensorUpdate), su.timestamp) AS minutes_since_start, " +
                "CASE su.status WHEN 'Niet vol' THEN 0 WHEN 'Vol' THEN 1 END AS status_numeric " +
                "FROM SensorUpdate su " +
                "ORDER BY su.timestamp ASC";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cleannet", "root", "bombo");
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                Number minutes = resultSet.getInt("minutes_since_start");
                Number statusNumeric = resultSet.getInt("status_numeric");

                System.out.println("Minuten: " + minutes + ", Status: " + statusNumeric);

                // Voeg de data toe aan de series
                XYChart.Data<Number, Number> dataPoint = new XYChart.Data<>(minutes, statusNumeric);
                series.getData().add(dataPoint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Voeg de serie toe aan de grafiek
        lineChart.getData().add(series);

        System.out.println("Aantal datapunten in serie: " + series.getData().size());
    }

}
