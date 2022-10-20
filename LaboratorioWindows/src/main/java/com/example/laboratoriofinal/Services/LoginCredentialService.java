package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Enums.ObjectStatus;
import com.example.laboratoriofinal.Model.LoginCredential;

public interface LoginCredentialService {
    String createUsername(String monitorName);
    String createPassword(String id);
    LoginCredential createLoginCredential(String username, String password);

}
