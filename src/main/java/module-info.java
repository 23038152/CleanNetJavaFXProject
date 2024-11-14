module com.example.ja {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.ja to javafx.fxml;
    exports com.example.ja;
}