package com.example.newubhacking;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import static javafx.application.Application.launch;

public class CreateAccount extends Application {
    @FXML private TextField usernames;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Label incorrectL;
    @FXML private Button Login;
    @FXML private Button enter;
    private Statement stmt;
    public void changeScene(String fxml, Button button) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        PageInfo pageInfo = new PageInfo();

        Pane pane = null;
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void start(Stage stage) throws IOException {
        initializeDB();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Create account.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void aut() throws IOException {

        String query = "SELECT username FROM users WHERE username=" +"\""+usernames.getText()+"\""+";";  //get username
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/usersdb", "root","Itawtaw26");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!= null){
                String insertStmt =
                        "INSERT INTO users(username,password,email" +
                                ") VALUES('" +
                                usernames.getText().trim() + "','" +
                                password.getText().trim() + "','" +
                                email.getText().trim()  +
                                  "');";
                stmt.execute(insertStmt);
                Button button = enter;
                changeScene("hello-view.fxml", button);

            }else{
                incorrectL.setText("Username exists!!");
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
