package fr.cookorama.dashboard;

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

        PieChart pieChart = new PieChart();
        // Ajoute 3 données en guise d'exemple
        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
        PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
        PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        // Ajoute le graphique au layout
        customersChart.getData().add(slice1);
        customersChart.getData().add(slice2);
        customersChart.getData().add(slice3);

        for (PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                    System.out.println("Clicked on " + data.getName());
                }
            });
        }

    }
}
