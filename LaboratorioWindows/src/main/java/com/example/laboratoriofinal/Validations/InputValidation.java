package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;

public class InputValidation { // Validaciones para campos de entrada.
    // Los  numeros de celular unicamente deberan contener caracteres numericos
    public void verifyCellphoneNumberInput(String cellphone) throws InputException {
        try{
            Integer.parseInt(cellphone);
        }catch (NumberFormatException err){
            throw new InputException("El número de telefonico debe contener solo caracteres númericos.");
        }
    }
    // Los id unicamente deberan contener caracteres numericos
    public void verifyIdInput(String id) throws InputException{
        try{
            Integer.parseInt(id);
        }catch (NumberFormatException err){
            throw new InputException("El número de identificación debe contener solo caracteres númericos.");
        }
    }
    //El email debe contener @
    public void verifyEmail(String email) throws InputException{
        if(!email.contains("@")){
            throw new InputException("El correo electronico debe ser válido");
        }

    }
    //Funcion para que ningun campo de entrada quede vacio para asi evitar nulls.
    public  void verifyInputs(String name, String cellphone, String id, String email) throws InputException{
        if((name.equals(""))
                ||
                (cellphone.equals(""))
                ||
                (id.equals(""))
                ||
                (email.equals(""))
        ){
            throw new InputException("Debe completar todos los campos, por favor verifique.");

        }
    }

    public void verifyObjectInput(String objectName, String amount, String loanPrice) throws  InputException{
        if(
                (objectName.equals(""))
                ||
                (amount.equals(""))
                ||
                (loanPrice.equals(""))

        ){
            throw new InputException("Debe completar todos los campos, por favor verifique.");

        }
    }
    public void verifyInputNumbers(String number) throws InputException {
        try{
            Integer.parseInt(number);
        }catch (Exception err){
            throw new InputException("El campo deber ser completado con caracteres numericos.");
        }
    }

    public void verifyLoginInputs(String username, String password) throws  InputException{
        if(username.equals("") || password.equals("")) throw new InputException("Debe completar todos los campos, por favor verifique.");
    }
 }
