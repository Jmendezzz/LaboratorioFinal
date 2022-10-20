package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Objeto;
import javafx.collections.ObservableList;



public interface ObjetoService {
    void createObject(String objectName, String amount, String loanPrice, boolean status) throws InputException;
    Objeto searchObjectById(String id);
    void generateId(Objeto object);
    ObservableList<Objeto> getObjectsList();
    boolean translateStatus(String status);
    void modifyObject(String objectName, String amount, String loanPrice, boolean status, Objeto objeto) throws  InputException;
    void deleteObject(Objeto object) throws  InputException;
    Objeto getBestObject() throws InputException;

}
