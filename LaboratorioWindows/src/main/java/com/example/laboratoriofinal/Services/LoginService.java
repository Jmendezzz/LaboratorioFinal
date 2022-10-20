package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import javafx.collections.ObservableList;

public interface LoginService {

    Monitor verifyCredentials(ObservableList<Monitor> observableListMonitor, String username , String password) throws InputException;
    void showLoginResult(Monitor monitor) throws InputException;
    void changeLoginStatus(Monitor monitor);
    boolean adminLogin(String username , String password);


}
