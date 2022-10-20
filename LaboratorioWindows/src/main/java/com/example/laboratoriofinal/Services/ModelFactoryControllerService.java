package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ModelFactoryControllerService {
    //Monitor functions
    void createMonitor(String name, String email, String cellphoneNumber, String id) throws InputException;
    Monitor searchMonitor(String id );
    void modifyMonitor(String name, String email, String cellphoneNumber, String id,Monitor monitor) throws  InputException;
    void deleteMonitor(Monitor monitor) throws InputException;
    Monitor monitorLoginActive();
    public ObservableList<Monitor> getMonitorArrayList();
    Monitor getBestMonitor() throws InputException;
    // *______________________________________________________________________*
    //Scene functions
    void switchToMainMenu(ActionEvent e)  throws IOException;
    void switchScene(ActionEvent e,String resource) throws IOException;
    void switchToMonitorsScene(ActionEvent e) throws IOException;
    void switchToPrestamosScene(ActionEvent e) throws IOException;
    void switchToInventarioScene(ActionEvent e) throws IOException;
    void switchToStudentsScene(ActionEvent e) throws IOException;
    void switchToLoginScene(ActionEvent e) throws  IOException;
    // *______________________________________________________________________*

    //Students functions
    void createStudent(String name, String email, String cellphoneNumber, String id) throws  InputException;
    ObservableList<Estudiante> getObservableListStudents();
    Estudiante searchEstudent(String id);
    void modifyStudent(String name, String email, String cellphoneNumber, String id, Estudiante estudiante) throws InputException;
    void deleteStudent(Estudiante student) throws InputException;
    Estudiante getBestStudent () throws  InputException;
    // *______________________________________________________________________*

    //Object functions
    void createObject(String objectName, String amount, String loanPrice, boolean status) throws InputException;
    Objeto searchObjectById(String id);
    void generateId(Objeto object);
    ObservableList<Objeto> getObjectsList();
    boolean translateStatus(String status);
    void modifyObject(String objectName, String amount, String loanPrice, boolean status, Objeto objeto) throws InputException;
    void deleteObject(Objeto object) throws  InputException;
    Objeto getBestObject() throws InputException;
    // *______________________________________________________________________*
    //Loan functions
    public void createLoan(Monitor monitor, Estudiante student, ObservableList<DetallePrestamo> detallePrestamoList, LocalDate endLoanDate) throws InputException;
    DetallePrestamo addObjectsToLoan(Objeto object,String amount,ObservableList<DetallePrestamo> detallePrestamoList) throws InputException;
    ObservableList<Prestamo> getPrestamoList();



}
