package com.example.laboratoriofinal.Validations;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Estudiante;
import javafx.collections.ObservableList;


public class EstudianteValidation {
    public void verifyStudent(Estudiante student) throws InputException {
        if(student==null) throw new InputException("No se encontró ningún estudiante con esa identificacion, comprueba los datos de entrada.");
    }


    public void verifySelectedStudent(Estudiante student) throws  InputException{
        if (student== null) throw  new InputException("Debe seleccionar un estudiante, intentelo de nuevo.");
    }
    public void verifyStudentsList(ObservableList<Estudiante> observableListStudent) throws InputException {
        if(observableListStudent.size()<1) throw new InputException ("Aún no se han agregado estudiantes.");
    }
}
