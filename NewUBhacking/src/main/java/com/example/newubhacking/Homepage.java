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
    private Stage stage = new Stage();
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        //changeScene("Homepage.fxml");
        Pane pane = (Pane)FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene scene = new Scene(pane);
        stage.setTitle("Something Catchy");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    public void printHelloWorld(ActionEvent actionEvent) {
        actionEvent.consume();
        System.out.println("Hello, World!");
    }

    @FXML private javafx.scene.control.Button finAid;
    @FXML private javafx.scene.control.Button banking;
    @FXML private javafx.scene.control.Button savings;
    @FXML private javafx.scene.control.Button investment;
    @FXML private javafx.scene.control.Button taxes;
    @FXML private javafx.scene.control.Button housing;
    public void changeScene(String fxml, Button button) throws IOException {
        stage = (Stage)button.getScene().getWindow();
        stage.close();

        Pane pane = null;
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        Scene scene = new Scene(pane);
        stage.setTitle("Questionnaire");
        stage.setScene(scene);
        stage.show();
    }
    public void pressFinAid(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 1;
        Button button = finAid;
        changeScene("Questionnaire.fxml", button);
    }
    public void pressBanking(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 2;
        Button button = banking;
        changeScene("Questionnaire.fxml", button);

    }
    public void pressSavings(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 3;
        Button button = savings;
        changeScene("Questionnaire.fxml", button);
    }
    public void pressInvestment(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 4;
        Button button = investment;
        changeScene("Questionnaire.fxml", button);
    }
    public void pressTaxes(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 5;
        Button button = taxes;
        changeScene("Questionnaire.fxml", button);
    }
    public void pressHousing(ActionEvent actionEvent) throws IOException {
        actionEvent.consume();

        PageInfo pageInfo = new PageInfo();
        pageInfo.category = 6;
        Button button = housing;
        changeScene("Questionnaire.fxml", button);
    }
}

