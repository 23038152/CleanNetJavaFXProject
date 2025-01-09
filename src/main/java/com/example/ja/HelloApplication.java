package com.example.ja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Laad het login-scherm
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScherm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login scherm");
        stage.setScene(scene);
        stage.show();

        // Start de seriële communicatie
        startSerialCommunication();
    }
    private void startSerialCommunication() {
        // Maak een nieuwe instantie van SerialDatabaseHandler en stel de poort en baudrate in
        SerialDatabaseHandler handler = new SerialDatabaseHandler("COM4", 9600); // Vervang "COM4" met de juiste seriële poortnaam

        // Maak verbinding met de seriële poort
        if (handler.connectSerialPort()) {
            // Start een nieuwe thread om inkomende data te verwerken en de database bij te werken
            new Thread(() -> {
                // Zorg ervoor dat de seriële communicatie in een aparte thread draait
                // zodat de gebruikersinterface (UI) niet wordt geblokkeerd
                handler.connectDatabaseAndProcessData(); // Verwerk data en werk de database bij
                handler.closeSerialPort(); // Sluit de seriële poort na verwerking
            }).start();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
