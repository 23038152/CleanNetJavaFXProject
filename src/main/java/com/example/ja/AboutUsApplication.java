package com.example.ja; // Zorg dat dit jouw pakketnaam is

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class AboutUsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // Zorg dat het pad naar je FXML-bestand klopt
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ja/AboutUsPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Stel het venster in
            stage.setTitle("About Us Page"); // Pas de titel aan
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Log fouten als er iets misgaat
        }
    }
}