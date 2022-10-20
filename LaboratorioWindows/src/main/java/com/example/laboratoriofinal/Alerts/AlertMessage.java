package com.example.laboratoriofinal.Alerts;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.Optional;

public class AlertMessage {//Funciones de alertas para


    public void errMessage(String message){ // Mensaje de error.
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Dialogo de error");
        alert.setContentText("Algo ha salido mal...");
        Label label = new Label("Descripción del error");
        TextArea textArea = new TextArea(message);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea,Priority.ALWAYS);
        GridPane content = new GridPane();
        content.setMaxWidth(Double.MAX_VALUE);
        content.add(label,0,0);
        content.add(textArea,0,1);
        alert.getDialogPane().setExpandableContent(content);
        alert.showAndWait();

    }
    public void informationMessage(String message){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de información");
        alert.setTitle("Dialogo de información");
        alert.setContentText(message);
        alert.showAndWait();

    }
    public boolean confirmationMessage(String rol){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensaje de confirmación");
        alert.setHeaderText("Eliminación de "+ rol);
        alert.setContentText("¿Desea eliminar el "+ rol +" seleccionado?");
        ButtonType yesButton = new ButtonType("Si");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton,noButton);
        Optional<ButtonType> optional = alert.showAndWait();
        return optional.get() == yesButton;
    }

}
