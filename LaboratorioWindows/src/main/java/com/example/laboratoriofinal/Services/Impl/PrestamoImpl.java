package com.example.laboratoriofinal.Services.Impl;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.*;
import com.example.laboratoriofinal.Services.PrestamoService;
import com.example.laboratoriofinal.Validations.EstudianteValidation;
import com.example.laboratoriofinal.Validations.InputValidation;
import com.example.laboratoriofinal.Validations.PrestamoValidation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class PrestamoImpl implements PrestamoService {

    ObservableList<Prestamo> prestamoObservableList = FXCollections.observableArrayList();
    private final EstudianteValidation estudianteValidation = new EstudianteValidation();
    PrestamoValidation prestamoValidation = new PrestamoValidation();
    AlertMessage alertMessage = new AlertMessage();
    InputValidation inputValidation = new InputValidation();


    //crear prestamo, restar cantidades, sumar cantidades.

    @Override
    public void createLoan(Monitor monitor, Estudiante student, ObservableList<DetallePrestamo> detallePrestamoList, LocalDate endLoanDate) throws InputException {
        estudianteValidation.verifyStudent(student);
        prestamoValidation.verifyObservableList(detallePrestamoList);
        prestamoValidation.verifyEndDate(endLoanDate);
        prestamoValidation.verifyDateEndDate(endLoanDate);
        Prestamo prestamo = new Prestamo(monitor,student,detallePrestamoList,endLoanDate);
        generateId(prestamo);
        prestamo.setLoanPrice(calculateFinalLoanPrice(detallePrestamoList));
        prestamoObservableList.add(prestamo);
        restUnits(detallePrestamoList);
        addObjectLoanActive(detallePrestamoList);
        addTotalLoanObject(detallePrestamoList);
        monitor.setSalary(calculateSalaryMonitor(prestamo.getLoanPrice()));
        //FALTA GANANCIA DEL MONITOR Y COMPROBAR SI PASA LA FECHA DE PRESTAMO Y TERMINAMOS! ALGUNAS INTTERFACES GRAFICAS
        student.setLoansSolicited(student.getLoansSolicited()+1);
        monitor.setLoansRealized(monitor.getLoansRealized()+1);
        alertMessage.informationMessage("Prestamo creado correctamente, se le ha asignado el ID: "+prestamo.getId());
    }


    //Crear el detalle prestamo para el prestamos, con validaciones
    @Override
    public DetallePrestamo addObjectsToLoan(Objeto object, String amount,ObservableList<DetallePrestamo> detallePrestamoList) throws InputException {
        prestamoValidation.verifyObject(object);
        prestamoValidation.verifyObjectSatus(object);
        inputValidation.verifyInputNumbers(amount);
        prestamoValidation.verifyAmount(Integer.parseInt(amount),object);
        prestamoValidation.verifyTotalAmount(object,Integer.parseInt(amount),detallePrestamoList);
        return  new DetallePrestamo(object ,Integer.parseInt(amount) );
    }


    //Obtener la lista de prestamos
    @Override
    public ObservableList<Prestamo> getPrestamoList() {

        return  prestamoObservableList;
    }


    // generar un id del prestmao
    @Override
    public void generateId(Prestamo loan) {
        int random = (int)(Math.random()*1000);
        for(Prestamo lo : prestamoObservableList){
            if(lo.getId()!=null){
                while(random == Integer.parseInt(lo.getId())) {
                    random = (int)(Math.random()*1000);
                }
            }
        }
        loan.setId(Integer.toString(random));

    }
    //calcular el precio total del prestamo
    public int calculateFinalLoanPrice(ObservableList<DetallePrestamo> detallePrestamoList){
        int acumulator = 0;
        for(DetallePrestamo detallePrestamo : detallePrestamoList){
            acumulator+= detallePrestamo.getAmount() * detallePrestamo.getObject().getLoanPrice();
        }
        return acumulator;
    }
    //Calcular salario, ganancia del monitor

    public double calculateSalaryMonitor(int priceLoan){
        return priceLoan * 0.5;
    }

    public void restUnits(ObservableList<DetallePrestamo> detallePrestamoList){
        for(DetallePrestamo detallePrestamo : detallePrestamoList){
            detallePrestamo.getObject().setAvaibleAmount(
                    detallePrestamo.getObject().getAvaibleAmount()-detallePrestamo.getAmount()
            );
        }
    }
    public void addObjectLoanActive(ObservableList<DetallePrestamo> detallePrestamoList){
        for(DetallePrestamo detallePrestamo : detallePrestamoList){
            detallePrestamo.getObject().setLoanActives(
                    detallePrestamo.getObject().getLoanActives()+1
            );
        }
    }
    public void addTotalLoanObject(ObservableList<DetallePrestamo> detallePrestamoList){
        for(DetallePrestamo detallePrestamo : detallePrestamoList){
            detallePrestamo.getObject().setTotalLoans(
                    detallePrestamo.getObject().getTotalLoans()+1
            );
        }
    }
}
