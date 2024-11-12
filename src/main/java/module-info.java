module com.example.ejerciciol {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens es.joel.ejerciciol to javafx.fxml;
    opens es.joel.ejerciciol.Model to javafx.base;

    exports es.joel.ejerciciol;
    exports es.joel.ejerciciol.Model;
}