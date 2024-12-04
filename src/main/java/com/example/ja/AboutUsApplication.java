package com.example.ja; // Zorg dat dit jouw pakketnaam is

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsApplication extends Application {


    @Override
    public void start(Stage stage) {
        try {
            // Zorg dat het pad naar je FXML-bestand klopt
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/AboutUS.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);

            // Stel het venster in
            stage.setTitle("About Us Page"); // Pas de titel aan
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Log fouten als er iets misgaat
            System.out.println("Foutmelding");
        }
    }
      public static void main(String[] args) {
        launch(args);
    }
}