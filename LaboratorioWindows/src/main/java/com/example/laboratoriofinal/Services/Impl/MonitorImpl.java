package com.example.laboratoriofinal.Services.Impl;
import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Services.MonitorService;
import com.example.laboratoriofinal.Validations.InputValidation;
import com.example.laboratoriofinal.Validations.MonitorValidation;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class MonitorImpl implements MonitorService {
    private final MonitorValidation monitorValidations = new MonitorValidation();
    private final InputValidation inputValidation = new InputValidation();
    private  final AlertMessage alertMessage = new AlertMessage();
    private final LoginCredentialImpl loginCredentialService = new LoginCredentialImpl();

    ObservableList<Monitor> observableListMonitor= FXCollections.observableArrayList();
    @Override //Crear monitor
    public void createMonitor(String name, String email, String cellphoneNumber, String id) throws InputException {

        inputValidation.verifyInputs(name,email,cellphoneNumber,id);
        inputValidation.verifyIdInput(id);
        inputValidation.verifyEmail(email);
        inputValidation.verifyCellphoneNumberInput(cellphoneNumber);
        Monitor addedMonitor= new Monitor(name,email,cellphoneNumber,id);
        addedMonitor.setLoginCredentials(
                loginCredentialService.createLoginCredential(

                loginCredentialService.createUsername(name),
                loginCredentialService.createPassword(id)
        )
        );
        observableListMonitor.add(addedMonitor);

        alertMessage.informationMessage("Monitor añadido correctamente");
        alertMessage.informationMessage("Datos de inicio de sesión al sistema: \n"+
                "Usuario: "+ addedMonitor.getLoginCredentials().getUsername() + "\n"+
                "Contraseña: " + addedMonitor.getLoginCredentials().getPassword());

    }

    @Override //Modificar monitor
    public void modifyMonitor(String name, String email, String cellphoneNumber, String id,Monitor monitor) throws InputException {
        monitorValidations.verifySelectedMonitor(monitor);
        inputValidation.verifyInputs(name,email,cellphoneNumber,id);
        inputValidation.verifyIdInput(id);
        inputValidation.verifyEmail(email);
        inputValidation.verifyCellphoneNumberInput(cellphoneNumber);
        monitor.setName(name);
        monitor.setId(id);
        monitor.setCellphoneNumber(cellphoneNumber);
        monitor.setEmail(email);
    }

    @Override // Eliminar monitor seleccionado
    public void deleteMonitor(Monitor monitor) throws InputException {
        monitorValidations.verifySelectedMonitor(monitor);
        if(alertMessage.confirmationMessage("Monitor")){
            observableListMonitor.remove(monitor);
            alertMessage.informationMessage("El monitor "+ monitor.getName()  +" ha sido eliminado!");
        }else alertMessage.informationMessage("El monitor no ha sido eliminado, acción cancelada.");

    }

    //Retornar lista de monitores para otros modulos.
    public ObservableList<Monitor> getObservableListMonitor() {
        return observableListMonitor;
    }

    @Override// Buscar monitor por medio del id
    public Monitor searchMonitor(String id)  {
            for(Monitor mon : observableListMonitor){
                if(mon.getId().equals(id)) return mon;
            }
            return null;
        }
    @Override
    public Monitor monitorLoginActive(){
        for(Monitor mon : observableListMonitor){
            if(mon.isLoginStatus()) {
                System.out.println(mon.getName());
                return mon;
            }
        }
        return null;


    }

    @Override
    public Monitor getBestMonitor()  throws InputException{
        monitorValidations.verifyMonitorList(observableListMonitor);
        Monitor bestMonitor = observableListMonitor.get(0);
        for(Monitor mon : observableListMonitor){
            bestMonitor = mon.getLoansRealized()> bestMonitor.getLoansRealized()? mon : bestMonitor;

        }
        return bestMonitor;
    }

}
