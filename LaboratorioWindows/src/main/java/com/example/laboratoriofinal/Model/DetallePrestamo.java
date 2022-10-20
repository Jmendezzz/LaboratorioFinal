package com.example.laboratoriofinal.Model;

public class DetallePrestamo {

    Objeto object;
    int amount;

    public DetallePrestamo(Objeto object, int amount) {
        this.object = object;
        this.amount = amount;
    }

    public Objeto getObject() {
        return object;
    }

    public void setObject(Objeto object) {
        this.object = object;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
