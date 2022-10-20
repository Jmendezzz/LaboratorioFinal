package com.example.laboratoriofinal.Controller;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Model.Objeto;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import com.example.laboratoriofinal.Validations.ObjetoValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ObjetoController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    private  final AlertMessage alertMessage = new AlertMessage();
    private  final ObjetoValidation objetoValidation = new ObjetoValidation();
    private final LoginImpl loginService = new LoginImpl();
    Monitor monitorLoginActive = mfc.monitorLoginActive();

    Objeto objectSelected;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(mfc.getObjectsList());
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        logOutButton.setGraphic(imageView);
        nameCol.setCellValueFactory((new PropertyValueFactory<>("objectName")));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        avaibleAmountCol.setCellValueFactory(new PropertyValueFactory<>("avaibleAmount"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("loanPrice"));
        loanCol.setCellValueFactory(new PropertyValueFactory<>("loanActives"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("tableStatus"));

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            objectSelected = newSelection;
            showObjectInformation(objectSelected);

        });

    }
    @FXML
    private Button logOutButton;
    Image img = new Image("C:\\Users\\jugem\\OneDrive\\Desktop\\Laboratorio windows\\LaboratorioWindows\\src\\main\\resources\\images\\logOutImg.png");
    ImageView imageView = new ImageView(img);
    @FXML
    private TableColumn<Objeto, Integer> avaibleAmountCol;
    @FXML
    private RadioButton activeCheckBox;

    @FXML
    private TableColumn<Objeto, Integer> amountCol;

    @FXML
    private TextField amountField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button estudiantesButton;

    @FXML
    private TableColumn<Objeto, String> idCol;

    @FXML
    private RadioButton inactiveCheckBox;

    @FXML
    private Button inventarioButton;

    @FXML
    private TableColumn<Objeto, Integer> loanCol;

    @FXML
    private Button monitorButton;

    @FXML
    private TableColumn<Objeto, String> nameCol;

    @FXML
    private TextField nameField;

    @FXML
    private Button prestamosButton;

    @FXML
    private TableColumn<Objeto, Integer> priceCol;

    @FXML
    private TextField priceField;

    @FXML
    private Button saveButton;

    @FXML
    private Button searchButton;

    @FXML
    private VBox sideBarMenu;

    @FXML
    private TableColumn<Objeto, String> statusCol;

    @FXML
    private TableView<Objeto> table;
    @FXML
    private TextField searchField;
    @FXML
    void swithToLoginScene(ActionEvent event)throws IOException{
        mfc.switchToLoginScene(event);
        loginService.changeLoginStatus(monitorLoginActive);
    }

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
    void switchtoStudentsScene(ActionEvent event) throws IOException {
        mfc.switchToStudentsScene(event);

    }

    void showObjectInformation(Objeto objectSelected){
        if(objectSelected!=null){

            nameField.setText(objectSelected.getObjectName());
            amountField.setText(Integer.toString(objectSelected.getAmount()));
            priceField.setText(Integer.toString(objectSelected.getLoanPrice()));
            activeCheckBox.setSelected(objectSelected.isStatus());
            inactiveCheckBox.setSelected(!objectSelected.isStatus());

        }

    }
    public void clearInputs(){
        nameField.setText("");
        amountField.setText("");
        priceField.setText("");
        inactiveCheckBox.setSelected(false);
        activeCheckBox.setSelected(false);
    }
    @FXML
    void createObject() {
        try{
            mfc.createObject(
                    nameField.getText(),
                    amountField.getText(),
                    priceField.getText(),
                    mfc.translateStatus(selectedCheckBox()) // Se invoca el selectedCheckBox para saber cual de los checkbox se selecciono.
            );
            table.setItems(mfc.laboratorio.getObjectService().getObjectsList());
            table.refresh();
            clearInputs();


        } catch (InputException e) {
            alertMessage.errMessage(e.getMessage());
        }

    }
    @FXML
    void modifyObject(){
        try {
            mfc.modifyObject(
                    nameField.getText(),
                    amountField.getText(),
                    priceField.getText(),
                    mfc.translateStatus(selectedCheckBox()),
                    objectSelected
            );

            table.setItems(mfc.laboratorio.getObjectService().getObjectsList());
            table.refresh();
            clearInputs();
            alertMessage.informationMessage("El objeto ha sido modificado.");


        }catch ( InputException err){
            alertMessage.errMessage(err.getMessage());
        }

    }
    @FXML
    void deleteObject(){
        try{
            mfc.deleteObject(objectSelected);
            table.setItems(mfc.laboratorio.getObjectService().getObjectsList());
            table.refresh();
            clearInputs();
        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }
    @FXML
    void searchObject(){
        objectSelected = mfc.searchObjectById(searchField.getText());
        try{
            objetoValidation.verifyObject(objectSelected);
            alertMessage.informationMessage("Objeto encontrado: " + objectSelected.getObjectName());
            table.getSelectionModel().select(objectSelected);
            showObjectInformation(objectSelected);

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());

        }
    }

    //Determinar cual checkbox está seleccionado para poder crear un objeto.
    String selectedCheckBox(){
        return (activeCheckBox.isSelected()) ? activeCheckBox.getText():inactiveCheckBox.getText();
    }


}
