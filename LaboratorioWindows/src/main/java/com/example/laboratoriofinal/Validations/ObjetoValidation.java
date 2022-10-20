package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Model.Objeto;
import javafx.collections.ObservableList;

public class ObjetoValidation {
    public void verifySelectedObject(Objeto object) throws InputException {
        if (object== null) throw  new InputException("Debe seleccionar un objeto, intentelo de nuevo.");
    }
    public void verifyObject(Objeto objeto) throws InputException {
        if (objeto == null ) throw  new InputException("No se han encontrado coincidencias, intentelo de nuevo");
    }
    public void verifyObjectList(ObservableList<Objeto> observableListObject) throws  InputException{
        if(observableListObject.size()<1) throw new InputException("Aún no se han agregado objetos");
    }
}
