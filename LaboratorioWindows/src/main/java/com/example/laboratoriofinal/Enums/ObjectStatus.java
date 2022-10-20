package com.example.laboratoriofinal.Enums;

public enum ObjectStatus {
    ACTIVE("Activado"),
    INACTIVE("Desactivado");

    private String status;
    private ObjectStatus(String status){
        this.status=status;
    }
    public String getStatusString(){
        return this.status;
    }
}
