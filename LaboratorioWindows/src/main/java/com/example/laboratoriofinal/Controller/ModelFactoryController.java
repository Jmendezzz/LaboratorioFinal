package com.example.laboratoriofinal.Controller;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.*;
import com.example.laboratoriofinal.Services.Impl.Laboratorio;
import com.example.laboratoriofinal.Services.ModelFactoryControllerService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelFactoryController implements ModelFactoryControllerService {
    Laboratorio laboratorio;




    private static class SingletonHolder{

        private final static ModelFactoryController eINSTANCE = new  ModelFactoryController();

    }

    //Obtener instancia de la clase
    public static ModelFactoryController getInstance(){return SingletonHolder.eINSTANCE;}

    public ModelFactoryController(){
        laboratorio = new Laboratorio();
    }

    // Todas las funciones del programa;

    //FUNCIONES MONITORES
    @Override
    public void createMonitor(String name, String email, String cellphoneNumber, String id) throws InputException {
        laboratorio.getMonitorService().createMonitor(name,email,cellphoneNumber,id);

    }

    @Override
    public ObservableList<Monitor> getMonitorArrayList() {
        return laboratorio.getMonitorService().getObservableListMonitor();
    }

    @Override
    public Monitor getBestMonitor() throws InputException{
        return laboratorio.getMonitorService().getBestMonitor();
    }

    @Override
    public Monitor searchMonitor(String id) {
        return laboratorio.getMonitorService().searchMonitor(id);
    }

    @Override
    public void modifyMonitor(String name, String email, String cellphoneNumber, String id, Monitor monitor) throws InputException {
        laboratorio.getMonitorService().modifyMonitor(name,email,cellphoneNumber,id,monitor);
    }

    @Override
    public void deleteMonitor(Monitor monitor) throws InputException {
        laboratorio.getMonitorService().deleteMonitor(monitor);
    }

    @Override
    public Monitor monitorLoginActive() {
        return laboratorio.getMonitorService().monitorLoginActive();
    }

    //****** FUNCIONES DE CAMBIOS DE ESCENA**********////
    @Override
    public void switchToMainMenu(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToMainMenu( e);
    }

    @Override
    public void switchScene(ActionEvent e, String resource) throws IOException {

        laboratorio.getSceneService().switchScene(e,resource);

    }
    @Override
    public void switchToMonitorsScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToMonitorsScene(e);
    }

    @Override
    public void switchToPrestamosScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToPrestamosScene(e);

    }

    @Override
    public void switchToInventarioScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToInventarioScene(e);

    }

    @Override
    public void switchToStudentsScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchtoStudentsScene(e);
    }

    @Override
    public void switchToLoginScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToLoginScene(e);
    }

    //********* ***********///

    //ESTUDIANTES FUNCTIONS
    @Override
    public void createStudent(String name, String email, String cellphoneNumber, String id) throws InputException {
        laboratorio.getStudentService().createStudent( name,  email,  cellphoneNumber,  id);
    }

    @Override
    public ObservableList<Estudiante> getObservableListStudents() {
        return laboratorio.getStudentService().getObservableListStudents();
    }

    @Override
    public Estudiante searchEstudent(String id) {
        return laboratorio.getStudentService().searchEstudent(id);
    }

    @Override
    public void modifyStudent(String name, String email, String cellphoneNumber, String id, Estudiante estudiante) throws InputException {
        laboratorio.getStudentService().modifyStudent(name,email,cellphoneNumber,id,estudiante);
    }

    @Override
    public void deleteStudent(Estudiante student) throws InputException {
        laboratorio.getStudentService().deleteStudent(student);
    }

    @Override
    public Estudiante getBestStudent() throws InputException {
        return  laboratorio.getStudentService().getBestStudent();
    }


    //********* ***********///

    //OBJECTS FUNCIONS
    @Override
    public void createObject(String objectName, String amount, String loanPrice, boolean status) throws InputException {
        laboratorio.getObjectService().createObject(objectName,amount,loanPrice,status);

    }

    @Override
    public Objeto searchObjectById(String id) {
        return laboratorio.getObjectService().searchObjectById(id);
    }

    @Override
    public void generateId(Objeto object) {
        laboratorio.getObjectService().generateId(object);

    }

    @Override
    public ObservableList<Objeto> getObjectsList() {
        return laboratorio.getObjectService().getObjectsList();
    }

    @Override
    public boolean translateStatus(String status) {
        return laboratorio.getObjectService().translateStatus(status);
    }

    @Override    public void modifyObject(String objectName, String amount, String loanPrice, boolean status, Objeto objeto) throws InputException {
        laboratorio.getObjectService().modifyObject(objectName,amount,loanPrice,status,objeto);
    }

    @Override
    public void deleteObject(Objeto object) throws InputException {
        laboratorio.getObjectService().deleteObject(object);
    }

    @Override
    public Objeto getBestObject() throws InputException {
        return laboratorio.getObjectService().getBestObject();
    }


    //********* ***********///

    //LOAN FUNCTIONS
    @Override
    public void createLoan(Monitor monitor, Estudiante student, ObservableList<DetallePrestamo> detallePrestamoList, LocalDate endLoanDate) throws InputException {
        laboratorio.getLoanService().createLoan(monitor,student,detallePrestamoList,endLoanDate);
    }

    @Override
    public DetallePrestamo addObjectsToLoan(Objeto object, String amount,ObservableList<DetallePrestamo> detallePrestamoList) throws InputException {
        return laboratorio.getLoanService().addObjectsToLoan(object,amount,detallePrestamoList);
    }

    @Override
    public ObservableList<Prestamo> getPrestamoList() {
        return laboratorio.getLoanService().getPrestamoList();
    }


}
