package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.DetallePrestamo;
import com.example.laboratoriofinal.Model.Objeto;
import com.example.laboratoriofinal.Model.Prestamo;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class PrestamoValidation {
    public  void verifyObservableList(ObservableList<DetallePrestamo> observableList) throws InputException {
        if(observableList.size()==0){
            throw new InputException("Aún no se ha agregado ningún articulo al prestamo");
        }
    }
    public  void verifyEndDate (LocalDate endLoanDate) throws InputException {

        if(endLoanDate==null){
            throw new InputException("Debe agregar la fecha fin del prestamo, intentelo de nuevo");
        }

    }

    public void verifyObject(Objeto objeto) throws InputException {
        if(objeto==null){
            throw new InputException("Debe selecciounar un objeto");
        }
    }
    public void verifyAmount (int amount, Objeto object ) throws  InputException{
        System.out.println(object.getAvaibleAmount());
        if(amount> object.getAvaibleAmount()){
            throw new InputException("Cantidad invalida, la cantidad ingresada es mayor que la cantidad disponible!");
        }
    }
    public void verifyDetallePrestamo(DetallePrestamo detallePrestamo) throws InputException {
        if(detallePrestamo==null){
            throw new InputException("Debe selecciounar un elemento de la tabla de prestamo temporal para poder eliminarlo.");
        }
    }
    public  void verifyTotalAmount(Objeto objeto, int amount, ObservableList<DetallePrestamo> observableList) throws InputException{
        int acumulator =0;
        for(DetallePrestamo  detallePrestamo: observableList){
            if(detallePrestamo.getObject() == objeto){
                acumulator+=detallePrestamo.getAmount();

            }
        }
        if(acumulator + amount > objeto.getAvaibleAmount()){
            throw new InputException("Cantidad invalida, la cantidad ingresada es mayor que la cantidad disponible!");
        }
    }
    public void verifyDateEndDate(LocalDate endDate) throws InputException {
        if(endDate.isBefore(LocalDate.now())) throw new InputException("Ingrese una fecha válida, la fecha ingresada es antes que la fecha de inicio del prestamo");
    }
    public void verifyObjectSatus(Objeto objeto) throws InputException {
        if(!objeto.isStatus()) throw  new InputException("El objeto seleccionado no está disponible para prestamo, compruebe el estado");
    }
}
