package com.stages.laboratorinis3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Stage1Controller {
    @FXML
    private TextField firstNameField, idField, lastNameField;
    @FXML
    private Button login1Button, login2Button, login3Button;

    public void login1(ActionEvent event) throws IOException {
        Person login = getInfo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage21.fxml"));
        Parent root = loader.load();
        Stage stage21 = new Stage();
        stage21.setUserData(login);
        stage21.setScene(new Scene(root));
        stage21.setTitle("Stage21");
        Stage21Controller stage21Controller = loader.getController();
        stage21Controller.printName();
        stage21.show();
        closeStage();
    }

    public void login2(ActionEvent event) throws IOException {
        Person login = getInfo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage22.fxml"));
        Parent root = loader.load();
        Stage22Controller stage22Controller = loader.getController();
        stage22Controller.verify(login);
        Stage stage22 = new Stage();
        stage22.setScene(new Scene(root));
        stage22.setTitle("Stage22");
        stage22.show();
        closeStage();
    }

    public void login3(ActionEvent event) throws IOException {
        Person login = getInfo();
        LoginData loginData = LoginData.getLoginData();
        loginData.setLogin(login);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage23.fxml"));
        Parent root = loader.load();
        Stage stage23 = new Stage();
        stage23.setScene(new Scene(root));
        stage23.setTitle("Stage23");
        Stage23Controller stage23Controller = loader.getController();
        stage23Controller.printName();
        stage23.show();
        closeStage();
    }
    public void closeStage(){
        Stage currentStage = (Stage) login1Button.getScene().getWindow();
        currentStage.close();
    }
    public Person getInfo(){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int id = Integer.parseInt(idField.getText());
        return new Person(firstName, lastName, id);
    }
}
