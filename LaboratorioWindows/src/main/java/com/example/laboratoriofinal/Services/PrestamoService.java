package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public interface PrestamoService {
    void createLoan(Monitor monitor, Estudiante student, ObservableList<DetallePrestamo> detallePrestamoList, LocalDate startLoanDate) throws InputException;
    DetallePrestamo addObjectsToLoan(Objeto object, String amount,ObservableList<DetallePrestamo> detallePrestamoList) throws InputException;
    ObservableList<Prestamo> getPrestamoList();
    void generateId(Prestamo loan);
}
