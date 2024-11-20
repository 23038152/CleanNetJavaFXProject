package com.example.ja; // Gebruik jouw pakketnaam

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/homepage.fxml")); // Zorg dat het pad klopt
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mijn Homepage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
