package com.example.laboratoriofinal.Enums;

public enum AdminCredential {
    USERNAME("admin"),
    PASSWORD("123");

    private String credentials;


    private  AdminCredential(String credentials){
            this.credentials = credentials;
        }
        public String getCredentials(){
            return this.credentials;
        }
    }
