package com.example.laboratoriofinal.Controller;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.DetallePrestamo;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Model.Objeto;
import com.example.laboratoriofinal.Model.Prestamo;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import com.example.laboratoriofinal.Validations.ObjetoValidation;
import com.example.laboratoriofinal.Validations.PrestamoValidation;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PrestamoContoller implements Initializable {
    ObservableList<DetallePrestamo> temporalyLoanList = FXCollections.observableArrayList();
    Objeto objectInventorySelected;
    DetallePrestamo detallePrestamoSelected;
    Prestamo prestamoSelected;
    public final LoginImpl loginService = new LoginImpl();
    private final PrestamoValidation prestamoValidation = new PrestamoValidation();
    private  final ModelFactoryController  mfc  = ModelFactoryController.getInstance();
    AlertMessage alertMessage = new AlertMessage();
    Monitor monitorLoginActive = mfc.monitorLoginActive();
    Monitor monitor = mfc.monitorLoginActive();
    private final ObjetoValidation objetoValidation = new ObjetoValidation();
    @FXML
    private Button bestMonitorButton;

    @FXML
    private Button bestObjectButton;

    @FXML
    private Button bestStudentButton;

    Image img = new Image("C:\\Users\\jugem\\OneDrive\\Desktop\\Laboratorio windows\\LaboratorioWindows\\src\\main\\resources\\images\\delete.png");
    ImageView imageView = new ImageView(img);
    @FXML
    private Button deleteElementLoanButton;
    @FXML
    private Button logOutButton;
    Image imgLogOut = new Image("C:\\Users\\jugem\\OneDrive\\Desktop\\Laboratorio windows\\LaboratorioWindows\\src\\main\\resources\\images\\logOutImg.png");
    ImageView imageViewLogOut = new ImageView(imgLogOut);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        deleteElementLoanButton.setGraphic(imageView);
        imageViewLogOut.setFitHeight(70);
        imageViewLogOut.setFitWidth(70);
        logOutButton.setGraphic(imageViewLogOut);
        //Tabla inventario
        inventoryTable.setItems(mfc.getObjectsList());
        nameObjectCol.setCellValueFactory(new PropertyValueFactory<>("objectName"));
        amountAvaibleCol.setCellValueFactory(new PropertyValueFactory<>("avaibleAmount"));
        priceLoanCol.setCellValueFactory(new PropertyValueFactory<>("loanPrice"));

        inventoryTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            objectInventorySelected = newSelection;
        });
        //Tabla de prestamo
        temporalLoanTable.setItems(temporalyLoanList);
        nameObjectTemporalCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getObject().getObjectName()));
        amountLoanCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        temporalLoanTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            detallePrestamoSelected = newSelection;

        });

        //Tabla historial de prestamos
        loanRealizedTable.setItems(mfc.getPrestamoList());
        idLoanRealizedCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        monitorLoanRealizedCol.setCellValueFactory(cellData-> new ReadOnlyObjectWrapper<>(cellData.getValue().getMonitor().getName()));
        studentLoanRealizedCol.setCellValueFactory(cellData-> new ReadOnlyObjectWrapper<>(cellData.getValue().getStudent().getName()));
        startDateCol.setCellValueFactory(cellData-> new ReadOnlyObjectWrapper<>(cellData.getValue().getStartLoanDate().toString()));
        endDateCol.setCellValueFactory(cellDate -> new ReadOnlyObjectWrapper<>(cellDate.getValue().getEndLoanDate().toString()));
        priceLoanRealizedCol.setCellValueFactory(new PropertyValueFactory<>("loanPrice"));

        loanRealizedTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            prestamoSelected = newSelection;

        });
    }

    @FXML
    private Button addToTemporalLoanButton;

    @FXML
    private TableColumn<Objeto, Integer> amountAvaibleCol;

    @FXML
    private TableColumn<DetallePrestamo, Integer> amountLoanCol;

    @FXML
    private TextField amountLoanField;

    @FXML
    private Button completeLoanButton;



    @FXML
    private TableColumn<Prestamo, String> endDateCol;

    @FXML
    private DatePicker endLoanDate;

    @FXML
    private Button estudiantesButton;

    @FXML
    private TableColumn<Prestamo,String> idLoanRealizedCol;

    @FXML
    private TextField idStudentField;

    @FXML
    private Button inventarioButton;

    @FXML
    private TableView<Objeto> inventoryTable;

    @FXML
    private TableView<Prestamo> loanRealizedTable;


    @FXML
    private Button monitorButton;

    @FXML
    private TableColumn<Prestamo, String> monitorLoanRealizedCol;

    @FXML
    private TableColumn<Objeto, String> nameObjectCol;

    @FXML
    private TableColumn<DetallePrestamo, String> nameObjectTemporalCol;

    @FXML
    private Button prestamosButton;

    @FXML
    private TableColumn<Objeto, Integer> priceLoanCol;

    @FXML
    private TableColumn<Prestamo, Integer> priceLoanRealizedCol;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchObjectField;

    @FXML
    private VBox sideBarMenu;

    @FXML
    private TableColumn<Prestamo, String> startDateCol;

    @FXML
    private TableColumn<Prestamo, String > studentLoanRealizedCol;

    @FXML
    private TableView<DetallePrestamo> temporalLoanTable;
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
    void switchToMonitorsScene(ActionEvent event) throws IOException{
        mfc.switchToMonitorsScene(event);

    }

    @FXML
    void switchToPrestamosScene(ActionEvent event) throws IOException {
        mfc.switchToPrestamosScene(event);

    }
    @FXML
    void switchToStudentsScene(ActionEvent event) throws IOException {
        mfc.switchToStudentsScene(event);

    }

    @FXML
    void createLoan(){
        try{
            mfc.createLoan(monitor,mfc.searchEstudent(idStudentField.getText()), temporalyLoanList,endLoanDate.getValue());
            inventoryTable.refresh();
        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }

    }
    @FXML
    void addObjectToLoanArrayList(){
        try{
            temporalyLoanList.add(mfc.addObjectsToLoan(objectInventorySelected, amountLoanField.getText(),temporalyLoanList));

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }
    @FXML
    void searchObject(){
        objectInventorySelected = mfc.searchObjectById(searchObjectField.getText());
        try{
            objetoValidation.verifyObject(objectInventorySelected);
            alertMessage.informationMessage("Se ha seleccionado un obejeto: " + objectInventorySelected.getObjectName());
            inventoryTable.getSelectionModel().select(objectInventorySelected);

        } catch (InputException e) {
            alertMessage.errMessage(e.getMessage());
        }
    }
    @FXML
    void removeObjectFromLoanList(){
        try{
            prestamoValidation.verifyDetallePrestamo(detallePrestamoSelected);
            temporalyLoanList.remove(detallePrestamoSelected);
            alertMessage.informationMessage("Se ha eliminado el articulo del prestamo.");

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());

        }
    }
    @FXML
    void getBestMonitor(){
        try{
            alertMessage.informationMessage("El monitor con mas prestamos es: \n"+
                    mfc.getBestMonitor().getName() + "\n" +
                    "Identificado con el id: "+ mfc.getBestMonitor().getId() + "\n"+
                    "Con un total de: " + mfc.getBestMonitor().getLoansRealized() + " prestamos!");

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }

    }
    @FXML
    void getBestStudent(){

        try{
            alertMessage.informationMessage("El estudiante con mas prestamos solicitados es: \n"+
                    mfc.getBestStudent().getName() + "\n" +
                    "Identificado con el id: "+ mfc.getBestStudent().getId() + "\n"+
                    "Con un total de: " + mfc.getBestStudent().getLoansSolicited() + " prestamos solicitados!");

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }
    @FXML
    void getBestObject(){
        try{
            alertMessage.informationMessage("El objeto que mas se ha solicitado es: \n"+
                    mfc.getBestObject().getObjectName() + "\n" +
                    "Identificado con el id: "+ mfc.getBestObject().getId() + "\n"+
                    "Con un total de: " + mfc.getBestObject().getTotalLoans() + " veces solicitado!");


        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }

}
