module com.example.ejerciciol {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ejerciciol to javafx.fxml;
    opens com.example.ejerciciol.Model to javafx.base;

    exports com.example.ejerciciol;
    exports com.example.ejerciciol.Model;
}