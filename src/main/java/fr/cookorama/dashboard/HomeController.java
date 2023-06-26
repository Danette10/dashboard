package fr.cookorama.dashboard;

import fr.cookorama.dashboard.data.HomeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnEvents;

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnExit;

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private void handleClicks(ActionEvent event){
        if (event.getSource() == btnExit) {
            System.exit(0);
        }
    }

}