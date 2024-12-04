package com.example.ja;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AboutUsController {
    @FXML
    private Label infoLabel;

    @FXML
    protected void onAboutUsd() {
        infoLabel.setText("Welkom bij de About Us pagina!");
    }
}
