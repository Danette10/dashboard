package fr.cookorama.dashboard.data;

import com.roxstudio.utils.CUrl;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to get data from the customers page
 *
 * @see CustomersData
 */
public class CustomersData {

    /**
     * Method to get the number of customers by type of subscription
     *
     * @param customersChart PieChart to display the data
     * @param token Token of the user
     */
    public static void loadCustomersChart(PieChart customersChart, String token){

        CUrl curl = new CUrl("https://cookorama.fr/api/customers/chart");
        Map<String, String> headersSent = new HashMap<>();
        headersSent.put("Authorization", token);
        curl.headers(headersSent);
        curl.insecure();
        String response = curl.exec(CUrl.UTF8, null);

        JSONObject obj = new JSONObject(response);

        Boolean success = obj.getBoolean("success");
        if(success == false){
            System.out.println("Erreur lors de la récupération des données du graphique des clients");
            return;
        }

        JSONObject resultObj = obj.getJSONObject("result");

        int nbFree = resultObj.getInt("Free");
        int nbStarter = resultObj.getInt("Starter");
        int nbMaster = resultObj.getInt("Master");

        PieChart.Data slice1 = new PieChart.Data("Free", nbFree);
        PieChart.Data slice2 = new PieChart.Data("Starter", nbStarter);
        PieChart.Data slice3 = new PieChart.Data("Master", nbMaster);

        customersChart.getData().add(slice1);
        customersChart.getData().add(slice2);
        customersChart.getData().add(slice3);

        Tooltip tooltip = new Tooltip();
        tooltip.setShowDelay(Duration.seconds(0.1));

        for (PieChart.Data data : customersChart.getData()) {
            data.getNode().addEventHandler(
                    javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                    e -> {
                        double percentage = (data.getPieValue() / customersChart.getData().stream().mapToDouble(PieChart.Data::getPieValue).sum()) * 100;
                        tooltip.setText(data.getName() + " : " + String.format("%.2f", percentage) + "%");
                        Tooltip.install(data.getNode(), tooltip);
                    }
            );
        }
    }
}
