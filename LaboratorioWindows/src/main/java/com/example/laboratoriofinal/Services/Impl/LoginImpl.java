package com.example.laboratoriofinal.Services.Impl;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Enums.AdminCredential;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Services.LoginService;
import com.example.laboratoriofinal.Validations.InputValidation;
import com.example.laboratoriofinal.Validations.LoginValidation;
import javafx.collections.ObservableList;

public class LoginImpl implements LoginService {
    private final AlertMessage alertMessage = new AlertMessage();
    private final InputValidation inputValidation = new InputValidation();
    private final LoginValidation loginValidation = new LoginValidation();

    @Override
    public Monitor verifyCredentials(ObservableList<Monitor> observableListMonitor, String username, String password)throws InputException {
        inputValidation.verifyLoginInputs(username,password);
        for (Monitor monitor : observableListMonitor){
            if((monitor.getLoginCredentials().getUsername().equals(username))
                    && (monitor.getLoginCredentials().getPassword().equals(password))) return monitor;

        }
        return null;
    }

    @Override
    public void showLoginResult(Monitor monitor) throws InputException {
        loginValidation.verifyLoginMonitor(monitor);
        System.out.println(monitor.isLoginStatus());
        changeLoginStatus(monitor);
        System.out.println(monitor.isLoginStatus());
        alertMessage.informationMessage("Bienvenido "+ monitor.getName());


    }

    @Override
    public void changeLoginStatus(Monitor monitor) {
        if(monitor!=null){
            if(monitor.isLoginStatus()) monitor.setLoginStatus(false);
            else monitor.setLoginStatus(true);
        }

    }

    @Override
    public boolean adminLogin(String username, String password) {
        return username.equals(AdminCredential.USERNAME.getCredentials())
                &&
                password.equals(AdminCredential.PASSWORD.getCredentials());
    }
}
