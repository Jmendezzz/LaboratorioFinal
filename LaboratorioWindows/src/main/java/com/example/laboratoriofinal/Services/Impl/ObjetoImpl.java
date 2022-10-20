package com.example.laboratoriofinal.Services.Impl;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Enums.ObjectStatus;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Objeto;
import com.example.laboratoriofinal.Services.ObjetoService;
import com.example.laboratoriofinal.Validations.InputValidation;
import com.example.laboratoriofinal.Validations.ObjetoValidation;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ObjetoImpl implements ObjetoService {
    ObservableList<Objeto> observableListObject = FXCollections.observableArrayList();
    private final InputValidation inputValidation = new InputValidation();
    private final ObjetoValidation objetoValidation = new ObjetoValidation();
    private  final AlertMessage alertMessage = new AlertMessage();
    @Override
    public void createObject(String objectName, String amount, String loanPrice, boolean status) throws InputException {
        inputValidation.verifyObjectInput(objectName,amount,loanPrice);
        inputValidation.verifyInputNumbers(loanPrice);
        inputValidation.verifyInputNumbers(amount);

        observableListObject.add(new Objeto(objectName,Integer.parseInt(amount) ,Integer.parseInt(loanPrice) ,status));
        generateId(observableListObject.get(observableListObject.size()-1)); // Establezco el id, contando que siempre sera la ultima posicion.
        alertMessage.informationMessage("Objeto creado correctamente, se le ha asignado el ID: "+observableListObject.get(observableListObject.size()-1).getId());


    }

    @Override // Buscar un objeto por un id de entrada ( los ids son asignados por el sistema )
    public Objeto searchObjectById(String id) {

        for(Objeto obj : observableListObject){
            if(obj.getId().equals(id)) return obj;
        }
        return null;
    }

    @Override // Generar un id de manera aleatoria, se crea un while interno para evitar que se repitan los ids (0-1000);
    public void generateId(Objeto object) {
        int random = (int)(Math.random()*1000);
            for(Objeto obj : observableListObject){
                if(obj.getId()!=null){
                    while(random == Integer.parseInt(obj.getId())) {
                        random = (int)(Math.random()*1000);
                    }
                }
            }
            object.setId(Integer.toString(random));
    }

    @Override
    public ObservableList<Objeto> getObjectsList() {
        return observableListObject;
    }

    @Override // Como en los checkbox se recibe el texto, se hace una traduccion para convertirlo en booleano
    public boolean translateStatus(String status) {
        return status.equals(ObjectStatus.ACTIVE.getStatusString());
    }

    @Override //Modificar un objeto con nuevos valores.
    public void modifyObject(String objectName, String  amount, String loanPrice, boolean status, Objeto objeto) throws InputException{
        objetoValidation.verifySelectedObject(objeto);
        inputValidation.verifyObjectInput(objectName,amount,loanPrice);
        inputValidation.verifyInputNumbers(loanPrice);
        inputValidation.verifyInputNumbers(amount);
        objeto.setObjectName(objectName);
        objeto.setAmount(Integer.parseInt(amount));
        objeto.setLoanPrice(Integer.parseInt(loanPrice));
        objeto.setStatus(status);
        objeto.setTableStatus((status)? ObjectStatus.ACTIVE.getStatusString(): ObjectStatus.INACTIVE.getStatusString()) ;


    }

    @Override
    public void deleteObject(Objeto object) throws InputException {
        objetoValidation.verifySelectedObject(object);
        if(alertMessage.confirmationMessage("objeto")){
            observableListObject.remove(object);
            alertMessage.informationMessage("El objeto "+ object.getObjectName()  +" ha sido eliminado!");
        }else alertMessage.informationMessage("El objeto no ha sido eliminado, acción cancelada.");

    }

    @Override
    public Objeto getBestObject() throws InputException {
        objetoValidation.verifyObjectList(observableListObject);
        Objeto bestObjeto = observableListObject.get(0);
        for(Objeto object : observableListObject){
            bestObjeto = object.getTotalLoans()>bestObjeto.getTotalLoans() ? object : bestObjeto;
        }
        return bestObjeto;
    }
}
