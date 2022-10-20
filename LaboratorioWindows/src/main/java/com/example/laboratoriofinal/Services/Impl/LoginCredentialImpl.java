package com.example.laboratoriofinal.Services.Impl;

import com.example.laboratoriofinal.Model.LoginCredential;
import com.example.laboratoriofinal.Services.LoginCredentialService;

public class LoginCredentialImpl implements LoginCredentialService {
    @Override
    public String createUsername(String monitorName) {
        if(monitorName.split(" ").length-1>0){
            String arrayName [] = monitorName.split( " ");
            return arrayName[0] + "." + arrayName[1] + ".cue";
        }else return monitorName + ".cue";

    }

    @Override
    public String createPassword(String id) {
        return id;
    }

    @Override
    public LoginCredential createLoginCredential(String username, String password) {
        return  new LoginCredential(username,password);
    }


}
