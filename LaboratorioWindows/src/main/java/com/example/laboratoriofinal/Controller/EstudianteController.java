package com.example.laboratoriofinal.Controller;
import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Model.Estudiante;
import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import com.example.laboratoriofinal.Validations.EstudianteValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteController  implements Initializable {
    Estudiante estudianteSelected;
    private final AlertMessage alertMessage = new AlertMessage();
    private final EstudianteValidation estudianteValidation = new EstudianteValidation();
    private final LoginImpl loginService = new LoginImpl();


    ModelFactoryController mfc = ModelFactoryController.getInstance();
    Monitor monitorLoginActive = mfc.monitorLoginActive();

    @FXML
    private TextField cellphoneField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TableColumn<Estudiante, String> emailCol;

    @FXML
    private TextField emailField;
    @FXML
    private Button logOutButton;
    Image img = new Image("C:\\Users\\jugem\\OneDrive\\Desktop\\Laboratorio windows\\LaboratorioWindows\\src\\main\\resources\\images\\logOutImg.png");
    ImageView imageView = new ImageView(img);


    @FXML
    private Button estudiantesButton;

    @FXML
    private TableColumn<Estudiante, String> idCol;

    @FXML
    private TextField idField;

    @FXML
    private Button inventarioButton;

    @FXML
    private TableColumn<Estudiante, Integer> loanCol;

    @FXML
    private Button monitorButton;

    @FXML
    private TableColumn<Estudiante, String> nameCol;

    @FXML
    private TextField nameField;
    @FXML
    private TextField searchField;


    @FXML
    private Button prestamosButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button searchButton;

    @FXML
    private VBox sideBarMenu;

    @FXML
    private TableView<Estudiante> table;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(mfc.getObservableListStudents());
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        logOutButton.setGraphic(imageView);
        nameCol.setCellValueFactory((new PropertyValueFactory<>("name")));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        loanCol.setCellValueFactory(new PropertyValueFactory<>("loansSolicited"));

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            estudianteSelected = newSelection;
            showEstudianteInformation(estudianteSelected);

        });

    }
    public void showEstudianteInformation(Estudiante estudianteSelected){
        if(estudianteSelected!=null){

            nameField.setText(estudianteSelected.getName());
            cellphoneField.setText(estudianteSelected.getCellphoneNumber());
            idField.setText(estudianteSelected.getId());
            emailField.setText(estudianteSelected.getEmail());

        }
    }
    public void clearInputs(){
        nameField.setText("");
        cellphoneField.setText("");
        idField.setText("");
        emailField.setText("");
    }
    @FXML
    void createStudent() {
        try {
            mfc.createStudent(nameField.getText(),emailField.getText(),cellphoneField.getText(),idField.getText());
            table.setItems(mfc.laboratorio.getStudentService().getObservableListStudents());
            table.refresh();
            clearInputs();
        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }

    }
    @FXML
    void modifyStudent(){
        try{
            mfc.modifyStudent(nameField.getText(),emailField.getText(),cellphoneField.getText(),idField.getText(),estudianteSelected);
            table.setItems(mfc.laboratorio.getStudentService().getObservableListStudents());
            table.refresh();
            clearInputs();
            alertMessage.informationMessage("El estudiante ha sido modificado");

        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }
    @FXML
    void deleteStudent(){
        try{
            mfc.deleteStudent(estudianteSelected);
            table.setItems(mfc.laboratorio.getStudentService().getObservableListStudents());
            table.refresh();
            clearInputs();
        }catch (InputException err){
            alertMessage.errMessage(err.getMessage());

        }
    }
    @FXML
    void searchStudent(){

        estudianteSelected = mfc.searchEstudent(searchField.getText());

        try{
            estudianteValidation.verifyStudent(estudianteSelected);
            alertMessage.informationMessage("Estudiante encontrado: " + estudianteSelected.getName());
            table.getSelectionModel().select(estudianteSelected);
            showEstudianteInformation(estudianteSelected);


        }catch(InputException err){
            alertMessage.errMessage(err.getMessage());
        }
    }



}
