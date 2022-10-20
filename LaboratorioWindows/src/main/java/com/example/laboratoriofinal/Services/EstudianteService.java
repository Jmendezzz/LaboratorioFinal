package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Estudiante;
import javafx.collections.ObservableList;

public interface EstudianteService {
    void createStudent(String name, String email, String cellphoneNumber, String id) throws InputException;
    ObservableList<Estudiante> getObservableListStudents();
    Estudiante searchEstudent(String id);
    void modifyStudent(String name, String email, String cellphoneNumber, String id, Estudiante estudiante) throws InputException;
    void deleteStudent(Estudiante student) throws InputException;
    Estudiante getBestStudent () throws  InputException;
}
