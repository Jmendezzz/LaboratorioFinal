package com.example.laboratoriofinal.Controller;

import com.example.laboratoriofinal.Model.Monitor;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    Monitor monitorLoginActive = mfc.monitorLoginActive();
    private  final LoginImpl loginService = new LoginImpl();



    @FXML
    private Button estudiantesButton;

    @FXML
    private Button inventarioButton;

    @FXML
    private Label labelUsername;

    @FXML
    private Button logOutButton;

    @FXML
    private Button monitorButton;

    @FXML
    private Button prestamosButton;

    @FXML
    private VBox sideBarMenu;

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
    @FXML
    void switchToLoginScene(ActionEvent event) throws  IOException{
        mfc.switchToLoginScene(event);
        loginService.changeLoginStatus(monitorLoginActive);
    }
    File file = new File("src/main/resources/images/logOutImg.png");
    Image img = new Image(file.toURI().toString());
    ImageView imageView = new ImageView(img);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        logOutButton.setGraphic(imageView);
        welcomeMessage();

    }
    public void welcomeMessage(){
        if(monitorLoginActive!=null){
            labelUsername.setText(monitorLoginActive.getName());
            labelUsername.setText(monitorLoginActive.getName());
        }else labelUsername.setText("ADMIN");
    }
}

