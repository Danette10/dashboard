package fr.cookorama.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    private String token;

    public void initialize(URL location, ResourceBundle resources){

        System.out.println("Token: " + token);

    }

    public void setToken(String token) {
        this.token = token;
    }
}