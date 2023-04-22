package com.stages.laboratorinis3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Stage21Controller {
    @FXML
    Label helloLabel, balanceLabel, mainLabel, savingsLabel, warningLabel;
    @FXML
    Button depositButton, withdrawButton;
    @FXML
    TextField amountField;
    @FXML
    RadioButton mainButton, savingsButton;
    BankInfo user;
    Operations operations = new Operations();
    @FXML
    ToggleGroup type;

    int balanceType = 0;
    public void getType(ActionEvent event){
        if(mainButton.isSelected()){
            balanceType = 1;
        }
        if(savingsButton.isSelected()){
            balanceType = 2;
        }
    }
    public void printName(){
        Stage currentStage = (Stage) helloLabel.getScene().getWindow();
        Person login = (Person) currentStage.getUserData();
        operations.fillList();
        user = operations.verifyUser(login);
        if(user == null){
            helloLabel.setText("This user does not exist");
        }
        else{
            setText();
        }
    }

    public void deposit(ActionEvent event){
        float amount = 0;
        try{
            amount = Float.parseFloat(amountField.getText());
        }
        catch (NumberFormatException e){
            warningLabel.setText("Enter only a number!");
        }
        user.deposit(amount,balanceType);
        warningLabel.setText("You have deposited " + amount);
        setText();
    }
    public void withdraw(ActionEvent event){
        float amount = 0;
        try{
            amount = Float.parseFloat(amountField.getText());
        }
        catch (NumberFormatException e){
            warningLabel.setText("Enter only a number!");
        }
        if(!user.withdraw(amount,balanceType)){
            warningLabel.setText("Not enough balance to withdraw sum!");
        } else {
            warningLabel.setText("You have made a withdrawal of " + amount);
            setText();
        }
    }
    public void setText(){
        helloLabel.setText("Hello, " + user.firstName + " " + user.lastName + " (" + user.id + ")");
        balanceLabel.setText("Your balance: " + (user.mainBalance+ user.savings));
        mainLabel.setText("Main balance: " + user.mainBalance);
        savingsLabel.setText("Savings: " + user.savings);
    }
}
