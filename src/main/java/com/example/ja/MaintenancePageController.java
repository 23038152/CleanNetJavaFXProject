package com.example.ja;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class MaintenancePageController {

    @FXML
    private TitledPane maintenanceTitledPane;

    @FXML
    private Label infoLabel;

    @FXML
    public void initialize() {
        // Standaard tekst instellen
        infoLabel.setText("Welkom bij de Maintenance pagina!");

        // TitledPane standaard gesloten instellen
        if (maintenanceTitledPane != null) {
            maintenanceTitledPane.setExpanded(false);

            // Dynamisch openen/sluiten met een klik
            maintenanceTitledPane.setOnMouseClicked(event -> {
                boolean isExpanded = maintenanceTitledPane.isExpanded();
                maintenanceTitledPane.setExpanded(!isExpanded);
            });
        }
    }
}