module com.example.newubhacking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.newubhacking to javafx.fxml;
    exports com.example.newubhacking;
}