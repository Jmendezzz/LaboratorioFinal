package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;

public class LoginValidation {

    public  void verifyLoginMonitor(Monitor monitor) throws InputException {
        if (monitor == null ) throw new InputException("Datos invalidos, intentelo de nuevo");
    }
}
