package com.example.laboratoriofinal.Model;

public class Estudiante extends  Persona{
    int loansSolicited=0;

    public Estudiante(String name, String email, String cellphoneNumber, String id) {
        super(name, email, cellphoneNumber, id);
    }

    public int getLoansSolicited() {
        return loansSolicited;
    }

    public void setLoansSolicited(int loansSolicited) {
        this.loansSolicited = loansSolicited;
    }
}
