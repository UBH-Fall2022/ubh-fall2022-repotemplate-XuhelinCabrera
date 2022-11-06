package com.example.newubhacking;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Homepage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = (Pane) FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene scene = new Scene(pane);
        stage.setTitle("Something Catchy");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
