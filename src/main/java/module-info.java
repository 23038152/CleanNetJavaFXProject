module com.example.ja {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.ja to javafx.fxml;
    exports com.example.ja;
}