package com.example.ja;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController {
    @FXML
    private Button mijnButton;

    @FXML
    public void handleButtonClick() {
        System.out.println("Je wordt nu naar de juiste pagine geleid...");
    }
}
