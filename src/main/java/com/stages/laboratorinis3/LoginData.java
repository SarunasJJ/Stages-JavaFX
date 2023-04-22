package com.stages.laboratorinis3;

public class LoginData {
    private static LoginData loginData = null;
    private Person login = null;
    private LoginData(){
    }

    public synchronized static LoginData getLoginData(){
        if(loginData == null){
            loginData = new LoginData();
        }
        return loginData;
    }

    public Person getLogin() {
        return login;
    }

    public void setLogin(Person login) {
        this.login = login;
    }
}
