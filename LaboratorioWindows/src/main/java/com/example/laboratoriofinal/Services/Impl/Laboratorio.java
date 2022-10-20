package com.example.laboratoriofinal.Services.Impl;

import com.example.laboratoriofinal.SceneController;
import com.example.laboratoriofinal.Services.*;
import javafx.scene.Scene;

import java.util.PrimitiveIterator;

public class Laboratorio {
    private final MonitorService monitorService;
    private final SceneService sceneService;
    private final EstudianteService studentService;
    private final ObjetoService objectService;
    private final PrestamoService loanService;

    public Laboratorio() {
        monitorService = new MonitorImpl();
        sceneService = new SceneController();
        studentService = new EstudianteImpl();
        objectService = new ObjetoImpl();
        loanService = new PrestamoImpl();


    }
    public MonitorService getMonitorService(){return monitorService;}
    public SceneService getSceneService() {return sceneService;}
    public EstudianteService getStudentService(){
        return studentService;
    }
    public ObjetoService getObjectService(){
        return objectService;
    }
    public PrestamoService getLoanService(){
        return loanService;
    }
}
