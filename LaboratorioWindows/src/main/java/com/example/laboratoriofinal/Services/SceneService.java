package com.example.laboratoriofinal.Services;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface SceneService {
    void switchToMainMenu(ActionEvent e)  throws IOException;
    void switchScene(ActionEvent e, String resource) throws IOException;
    void switchToMonitorsScene(ActionEvent e) throws IOException;
    void switchToPrestamosScene(ActionEvent e) throws IOException;
    void switchToInventarioScene(ActionEvent e) throws IOException;
    void switchtoStudentsScene(ActionEvent e) throws IOException;
    public void switchToLoginScene(ActionEvent e) throws IOException;

}
