package fr.cookorama.dashboard;

import fr.cookorama.dashboard.data.CustomersData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersController extends HomeController implements Initializable {

    @FXML
    private PieChart customersChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CustomersData.loadCustomersChart(customersChart, super.getToken());
    }
}