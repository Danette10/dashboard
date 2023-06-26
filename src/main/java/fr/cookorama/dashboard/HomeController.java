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
    private Button btnHome;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnEvents;

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnExit;

    @FXML
    private Label nbCustomer;

    @FXML
    private Label nbEvents;

    @FXML
    private Label nbProducts;

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        int countCustomers = HomeData.getNbCustomers(token);
        int countEvents = HomeData.getNbEvents(token);
        int countProducts = HomeData.getNbProducts(token);

        if(countCustomers == -1){
            nbCustomer.setText("Erreur");
        } else if (countCustomers == 0){
            nbCustomer.setText("Aucun client");
        } else {
            nbCustomer.setText("Utilisateurs : " + countCustomers);
        }

        if(countEvents == -1){
            nbEvents.setText("Erreur");
        } else if (countEvents == 0){
            nbEvents.setText("Aucun évènement");
        } else {
            nbEvents.setText("Evènements : " + countEvents);
        }

        if(countProducts == -1){
            nbProducts.setText("Erreur");
        } else if (countProducts == 0){
            nbProducts.setText("Aucun produit");
        } else {
            nbProducts.setText("Produits : " + countProducts);
        }

    }

    @FXML
    private void handleClicks(ActionEvent event){
        if (event.getSource() == btnExit) {
            System.exit(0);
        }else if (event.getSource() == btnCustomers) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Cookorama - Clients");
                stage.setScene(new Scene(root));
                stage.show();
                ((Stage) btnCustomers.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (event.getSource() == btnEvents) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("events.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Cookorama - Evènements");
                stage.setScene(new Scene(root));
                stage.show();
                ((Stage) btnEvents.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (event.getSource() == btnProduct) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Cookorama - Produits");
                stage.setScene(new Scene(root));
                stage.show();
                ((Stage) btnProduct.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (event.getSource() == btnHome) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Cookorama - Accueil");
                stage.setScene(new Scene(root));
                stage.show();
                ((Stage) btnHome.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}