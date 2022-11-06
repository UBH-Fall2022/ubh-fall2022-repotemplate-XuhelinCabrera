module com.example.newubhacking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.newubhacking to javafx.fxml;
    exports com.example.newubhacking;
}