package com.example.laboratoriofinal.Services.Impl;
import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Estudiante;
import com.example.laboratoriofinal.Services.EstudianteService;
import com.example.laboratoriofinal.Validations.EstudianteValidation;
import com.example.laboratoriofinal.Validations.InputValidation;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class EstudianteImpl implements EstudianteService {
    private EstudianteValidation estudianteValidation = new EstudianteValidation();
    private final InputValidation inputValidation = new InputValidation();
    private final AlertMessage alertMessage = new AlertMessage();
    ObservableList<Estudiante> observableListStudent= FXCollections.observableArrayList();
    @Override
    public void createStudent(String name, String email, String cellphoneNumber, String id) throws InputException {
        inputValidation.verifyInputs(name,email,cellphoneNumber,id);
        inputValidation.verifyIdInput(id);
        inputValidation.verifyCellphoneNumberInput(cellphoneNumber);
        inputValidation.verifyEmail(email);
        observableListStudent.add(new Estudiante(name,email,cellphoneNumber,id));
    }

    @Override
    public ObservableList<Estudiante> getObservableListStudents() {
        return observableListStudent;
    }

    @Override // 14/10/2022 TERMINAR SABADO! *----- AQUI TERMINAMOS

    public Estudiante searchEstudent(String id) { // Buscar estudiante por medio del id

        for(Estudiante est : observableListStudent){
               if(est.getId().equals(id)) return est;
        }
        return  null;
    }

    @Override
    public void modifyStudent(String name, String email, String cellphoneNumber, String id, Estudiante estudiante) throws InputException {
        estudianteValidation.verifySelectedStudent(estudiante);
        inputValidation.verifyInputs(name,email,cellphoneNumber,id);
        inputValidation.verifyIdInput(id);
        inputValidation.verifyCellphoneNumberInput(cellphoneNumber);
        inputValidation.verifyEmail(email);
        estudiante.setName(name);
        estudiante.setEmail(email);
        estudiante.setId(id);
        estudiante.setCellphoneNumber(cellphoneNumber);
    }

    @Override
    public void deleteStudent(Estudiante student) throws InputException {

        estudianteValidation.verifySelectedStudent(student);
        if(alertMessage.confirmationMessage("Estudiante")){
            observableListStudent.remove(student);
            alertMessage.informationMessage("El estudiante " + student.getName()+ " ha sido eliminado!");
        }else alertMessage.informationMessage("El estudiante no ha sido eliminado, acción cancelada.\"");


    }

    @Override
    public Estudiante getBestStudent() throws InputException {
        estudianteValidation.verifyStudentsList(observableListStudent);
        Estudiante bestStudent = observableListStudent.get(0);
        for(Estudiante estudiante : observableListStudent){
            bestStudent= estudiante.getLoansSolicited()>bestStudent.getLoansSolicited()? estudiante : bestStudent;
        }
        return bestStudent;
    }
}
