package com.stages.laboratorinis3;

public class BankInfo extends Person{
    float mainBalance, savings;
    public BankInfo(String firstName, String lastName, int id, float mainBalance, float savings) {
        super(firstName, lastName, id);
        this.mainBalance = mainBalance;
        this.savings = savings;
    }

    public float getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(float mainBalance) {
        this.mainBalance = mainBalance;
    }

    public float getSavings() {
        return savings;
    }

    public void setSavings(float savings) {
        this.savings = savings;
    }

    public boolean withdraw(float withdrawalSum, int type) {
        float balance;
        if(type == 1){
            balance = mainBalance;
            balance-=withdrawalSum;
            if(balance<0){
                float savingsBalance = savings;
                savingsBalance += balance;
                balance = 0;
                if(savingsBalance<0){
                    return false;
                }
                savings = savingsBalance;
            }
            mainBalance = balance;
        }
        if(type == 2){
            balance = savings;
            balance-=withdrawalSum;
            if(balance<0){
                float main = mainBalance;
                main += balance;
                balance = 0;
                if(main<0){
                    return false;
                }
                mainBalance = main;
            }
            savings = balance;
        }
        return true;
    }

    public void deposit(float depositSum, int type){
        if(type == 1){
            mainBalance += depositSum;
        }
        if(type == 2){
            savings += depositSum;
        }
    }
}
