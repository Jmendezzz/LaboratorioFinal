package com.example.laboratoriofinal;

import com.example.laboratoriofinal.Controller.ModelFactoryController;
import com.example.laboratoriofinal.Services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;


import java.io.IOException;
import java.net.URL;

public class SceneController implements SceneService {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void switchToMainMenu(ActionEvent e) throws IOException {
        switchScene(e,"main-menu-view.fxml");
    }

    public void switchScene(ActionEvent e, String resource) throws IOException {
        root = FXMLLoader.load(getClass().getResource(resource));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 1400, 710);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMonitorsScene(ActionEvent e) throws IOException {
        switchScene(e,"monitor-view.fxml");
    }

    public void switchToPrestamosScene(ActionEvent e) throws IOException {
        switchScene(e,"prestamo-view.fxml");

    }
    public void switchToInventarioScene(ActionEvent e) throws IOException{
        switchScene(e,"inventario-view.fxml");
    }

    @Override
    public void switchtoStudentsScene(ActionEvent e) throws IOException {
        switchScene(e,"estudiantes-view.fxml");

    }
    public void switchToLoginScene(ActionEvent e) throws IOException{
        switchScene(e,"login-view.fxml");
    }


}
