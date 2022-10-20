package com.example.laboratoriofinal.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {
    String id;
    Monitor monitor;
    Estudiante student;
    ObservableList<DetallePrestamo> detallePrestamoList ;
    int loanPrice;
    LocalDate startLoanDate;
    LocalDate endLoanDate;

    public Prestamo(Monitor monitor, Estudiante student,ObservableList<DetallePrestamo> detallePrestamoList,LocalDate endLoanDate) {
        this.monitor = monitor;
        this.student = student;
        this.detallePrestamoList = detallePrestamoList;
        this.endLoanDate = endLoanDate;
        startLoanDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Estudiante getStudent() {
        return student;
    }

    public void setStudent(Estudiante student) {
        this.student = student;
    }

    public ObservableList<DetallePrestamo> getDetallePrestamoList() {
        return detallePrestamoList;
    }

    public void setDetallePrestamoList(ObservableList<DetallePrestamo> detallePrestamoList) {
        this.detallePrestamoList = detallePrestamoList;
    }

    public int getLoanPrice() {
        return loanPrice;
    }

    public void setLoanPrice(int loanPrice) {
        this.loanPrice = loanPrice;
    }

    public LocalDate getStartLoanDate() {
        return startLoanDate;
    }

    public void setStartLoanDate(LocalDate startLoanDate) {
        this.startLoanDate = startLoanDate;
    }

    public LocalDate getEndLoanDate() {
        return endLoanDate;
    }

    public void setEndLoanDate(LocalDate endLoanDate) {
        this.endLoanDate = endLoanDate;
    }
}
