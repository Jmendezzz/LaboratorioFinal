package com.example.laboratoriofinal.Services;

import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import javafx.collections.ObservableList;

public interface MonitorService {
    void createMonitor( String name, String email, String cellphoneNumber, String id) throws InputException;
    void modifyMonitor(String name, String email, String cellphoneNumber, String id,Monitor monitor) throws InputException;
    void deleteMonitor(Monitor monitor) throws InputException;
    ObservableList<Monitor> getObservableListMonitor();
    Monitor searchMonitor(String id);
    Monitor monitorLoginActive();
    Monitor getBestMonitor() throws InputException;


}
