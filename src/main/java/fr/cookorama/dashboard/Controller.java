package fr.cookorama.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    private String token;

    public void initialize(URL location, ResourceBundle resources){

        System.out.println("Token: " + token);

    }

    public void setToken(String token) {
        this.token = token;
    }
}