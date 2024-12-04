package com.example.ja;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MaintenancePageController {
    @FXML
    private Label infoLabel;

    @FXML
    public void initialize() {
        infoLabel.setText("Welkom bij de Maintenance pagina!");
    }
}