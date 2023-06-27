package fr.cookorama.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersController extends HomeController implements Initializable {

    @FXML
    private PieChart customersChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Tooltip tooltip = new Tooltip();
        tooltip.setShowDelay(Duration.seconds(0.1));

        PieChart.Data slice1 = new PieChart.Data("Free", 5);
        PieChart.Data slice2 = new PieChart.Data("Starter"  , 2);
        PieChart.Data slice3 = new PieChart.Data("Master" , 1);

        customersChart.getData().add(slice1);
        customersChart.getData().add(slice2);
        customersChart.getData().add(slice3);

        for (PieChart.Data data : customersChart.getData()) {
            data.getNode().addEventHandler(
                    javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                    e -> {
                        double percentage = (data.getPieValue() / customersChart.getData().stream().mapToDouble(PieChart.Data::getPieValue).sum()) * 100;
                        tooltip.setText("Utilisateurs : " + String.format("%.2f", percentage) + "%");
                        Tooltip.install(data.getNode(), tooltip);
                    }
            );
        }
    }
}