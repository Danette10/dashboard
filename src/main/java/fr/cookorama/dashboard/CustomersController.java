package fr.cookorama.dashboard;

import fr.cookorama.dashboard.data.CustomersData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the customers page
 *
 * @see Initializable
 * @see CustomersController
 * @see CustomersData
 */
public class CustomersController extends HomeController implements Initializable {

    /** Pie chart to display the number of customers */
    @FXML
    private PieChart customersChart;

    /**
     * Method to initialize the controller
     *
     * @param url
     * @param resourceBundle
     *
     * @see Initializable
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CustomersData.loadCustomersChart(customersChart, super.getToken());
    }
}