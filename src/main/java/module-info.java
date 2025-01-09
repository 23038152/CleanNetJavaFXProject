module com.example.ja {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires com.fazecast.jSerialComm;

    opens com.example.ja to javafx.fxml;
    exports com.example.ja;
}