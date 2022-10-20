package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import javafx.collections.ObservableList;

public class MonitorValidation { // validaciones para el controlador del monitor
    public void verifyMonitor(Monitor monitor) throws  InputException{
        if(monitor==null) throw new InputException("No se encontró ningun monitor con esa identificacion, comprueba los datos de entrada.");
    }


    public void verifySelectedMonitor(Monitor monitor) throws  InputException{
        if (monitor == null) throw  new InputException("Debe seleccionar un monitor, intentelo de nuevo.");
    }
    public void verifyMonitorList( ObservableList<Monitor> observableListMonitor) throws  InputException{
        if(observableListMonitor.size()<1) throw new InputException("Aún no se han agregado monitores.");
    }

}
