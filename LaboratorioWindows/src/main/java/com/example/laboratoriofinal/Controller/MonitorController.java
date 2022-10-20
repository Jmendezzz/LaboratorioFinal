package com.example.laboratoriofinal.Controller;
import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import com.example.laboratoriofinal.Validations.MonitorValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class MonitorController implements Initializable {
    public final AlertMessage alertMessage = new AlertMessage();
    public final MonitorValidation monitorValidation = new MonitorValidation();
    public final LoginImpl loginService = new LoginImpl();

    ModelFactoryController mfc= ModelFactoryController.getInstance();

    Monitor monitorSelected;
    Monitor monitorLoginActive = mfc.monitorLoginActive();

    @FXML
    private VBox hideForMonitor;
    @FXML
    private Button logOutButton;
    File file = new File("src/main/resources/images/logOutImg.png");
    Image img = new Image(file.toURI().toString());
    ImageView imageView = new ImageView(img);


    @FXML
    private TextField cellphoneMonitor;

    @FXML
    private TableColumn<Monitor, String> emailCol;

    @FXML
    private TextField emailMonitor;

    @FXML
    private Button estudiantesButton;

    @FXML
    private TableColumn<Monitor, String> idCol;

    @FXML
    private TextField idMonitor;

    @FXML
    private Button inventarioButton;

    @FXML
    private TableColumn<Monitor, String> loanCol;

    @FXML
    private Button monitorButton;

    @FXML
    private TableColumn<Monitor, String>nameCol;

    @FXML
    private TextField nameMonitor;

    @FXML
    private Button prestamosButton;

    @FXML
    private TableColumn<Monitor, String>salaryCol;

    @FXML
    private Button saveButton;

    @FXML
    private Button searchButton;

    @FXML
    private VBox sideBarMenu;
    @FXML
    private TextField searchField;

    @FXML
    private TableView<Monitor> table;
    @FXML
    void switchToInventarioScene(ActionEvent event) throws IOException {
        mfc.switchToInventarioScene(event);
    }

    @FXML
    void switchToMonitorsScene(ActionEvent event) throws IOException {
        mfc.switchToMonitorsScene(event);

    }

    @FXML
    void switchToPrestamosScene(ActionEvent event) throws IOException {
        mfc.switchToPrestamosScene(event);

    }
    @FXML
    void swithToStudentsScene(ActionEvent event)throws IOException{
        mfc.switchToStudentsScene(event);
    }
    @FXML
    void swithToLoginScene(ActionEvent event)throws IOException{
        mfc.switchToLoginScene(event);
        loginService.changeLoginStatus(monitorLoginActive);
    }

    @FXML
    void createMonitor() {
        try{
            mfc.createMonitor(nameMonitor.getText(),emailMonitor.getText(),cellphoneMonitor.getText(),idMonitor.getText());
            table.setItems(mfc.laboratorio.getMonitorService().getObservableListMonitor());
            table.refresh();
            clearInputs();

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }



    }
    @FXML
    void modifyMonitor(){
        try{
            mfc.modifyMonitor(nameMonitor.getText(),emailMonitor.getText(),cellphoneMonitor.getText(),idMonitor.getText(),monitorSelected);
            table.setItems(mfc.laboratorio.getMonitorService().getObservableListMonitor());
            table.refresh();
            clearInputs();
            alertMessage.informationMessage("Monitor editado correctamente");

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());

        }
    }
    @FXML
    void deleteMonitor(){

            try{
                mfc.laboratorio.getMonitorService().deleteMonitor(monitorSelected);
                table.setItems(mfc.laboratorio.getMonitorService().getObservableListMonitor());
                table.refresh();
                clearInputs();
            }catch (InputException err){
                alertMessage.errMessage(err.getMessage());
            }


    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        table.setItems(mfc.getMonitorArrayList());
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        logOutButton.setGraphic(imageView);
        nameCol.setCellValueFactory((new PropertyValueFactory<>("name")));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        loanCol.setCellValueFactory(new PropertyValueFactory<>("loansRealized"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            monitorSelected = newSelection;
            showMonitorInformation(monitorSelected);

        });
        setHideForMonitor();

    }
    @FXML
    void searchMonitor(){
        monitorSelected = mfc.laboratorio.getMonitorService().searchMonitor(searchField.getText());
        try{
            monitorValidation.verifyMonitor(monitorSelected);
            alertMessage.informationMessage("Monitor encontrado: " + monitorSelected.getName());
            table.getSelectionModel().select(monitorSelected);
            showMonitorInformation(monitorSelected);
        }catch(InputException err){
            alertMessage.errMessage(err.getMessage());

        }

    }
    public void showMonitorInformation(Monitor monitorSelected){
        if(monitorSelected!=null){

            nameMonitor.setText(monitorSelected.getName());
            cellphoneMonitor.setText(monitorSelected.getCellphoneNumber());
            idMonitor.setText(monitorSelected.getId());
            emailMonitor.setText(monitorSelected.getEmail());

        }
    }
    public void clearInputs(){
        nameMonitor.setText("");
        cellphoneMonitor.setText("");
        idMonitor.setText("");
        emailMonitor.setText("");
    }
    public void setHideForMonitor(){
        if(monitorLoginActive!=null){
            hideForMonitor.setVisible(false);
            hideForMonitor.setPrefHeight(0);
        };
    }




}