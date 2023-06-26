package fr.cookorama.dashboard;

import fr.cookorama.dashboard.data.HomeData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
    }
}