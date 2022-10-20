package com.example.laboratoriofinal.Controller;

import com.example.laboratoriofinal.Alerts.AlertMessage;
import com.example.laboratoriofinal.Exceptions.InputException;
import com.example.laboratoriofinal.Services.Impl.LoginImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    private  final LoginImpl loginService = new LoginImpl();
    private  final AlertMessage alertMessage = new AlertMessage();

    @FXML
    private Button loginButton;

    @FXML
    private VBox loginMainScreen;
    @FXML
    private MediaView mediaView;

    @FXML
    private PasswordField passwordField;

    @FXML
    private VBox sideBarMenu;

    @FXML
    private TextField usernameField;
    @FXML
    void switchToMainMenu(ActionEvent event) throws IOException {

        mfc.switchToMainMenu(event);

    }


    @FXML
    void login(ActionEvent event) throws IOException {
        if(!loginService.adminLogin(usernameField.getText(),passwordField.getText())){
            try {
                loginService.showLoginResult(loginService.verifyCredentials
                        (mfc.getMonitorArrayList(),usernameField.getText(),passwordField.getText())
                );
                switchToMainMenu(event);
            }catch (InputException err) {
                alertMessage.errMessage(err.getMessage());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else switchToMainMenu(event);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/videos/video.mp4");
        Media media = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.setVolume(0);
        player.play();
        player.setCycleCount(MediaPlayer.INDEFINITE);

    }
}

