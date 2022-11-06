package com.example.newubhacking;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label incorrectL;
    @FXML private Button Login;
    private Statement stmt;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        initializeDB();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public String User(){
        String userN = username.getText();
        return userN;
    }
    @FXML
    public void aut() {

        String q = "SELECT * FROM users WHERE username='" + username.getText() + "' AND password ='" + password.getText() + "'";
        Statement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/usersdb", "root","Itawtaw26");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            if(!rs.next()){
                incorrectL.setText("Invalid username or password");
            }else{
                //in here open next page
            }

        } catch (SQLException e) {
            System.out.println("no");

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void initializeDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/usersdb", "root","Itawtaw26");
            this.stmt = connection.createStatement();

        } catch (SQLException e) {
            System.out.println("no work!!!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}