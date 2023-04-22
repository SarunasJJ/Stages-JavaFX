package com.stages.laboratorinis3;

import java.util.ArrayList;
import java.util.Objects;

public class Operations {
    public ArrayList<BankInfo> userList = new ArrayList<>();

    public void fillList(){
        userList.add(new BankInfo("a", "b", 1, 5123.23F, 1200.00F));
        userList.add(new BankInfo("Jonas", "Valanciunas", 1, 5123.23F, 1200.00F));
        userList.add(new BankInfo("Sarunas", "Jasikevicius", 2, 12343.44F, 1230.11F));
        userList.add(new BankInfo("Gitanas", "Nauseda", 3, 203000.30F, 4400.00F));
        userList.add(new BankInfo("Petras", "Grazulis", 4, 33.23F, 9.12F));
    }

    public BankInfo verifyUser(Person login){
        BankInfo user;
        for (BankInfo bankInfo : userList) {
            if (Objects.equals(bankInfo.firstName, login.firstName) && Objects.equals(bankInfo.lastName,
                    login.lastName) && bankInfo.id == login.id) {
                user = bankInfo;
                return user;
            }
        }
        return null;
    }

}
