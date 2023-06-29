package fr.cookorama.dashboard.data;

import com.roxstudio.utils.CUrl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to get data from the home page
 *
 * @see HomeData
 */
public class HomeData {

    /**
     * Method to get the number of customers
     *
     * @param token Token of the user
     * @return Number of customers
     */
    public static int getNbCustomers(String token){
        CUrl curl = new CUrl("https://cookorama.fr/api/customers/count");
        Map<String, String> headersSent = new HashMap<String, String>();
        headersSent.put("Authorization", token);
        curl.headers(headersSent);
        curl.insecure();
        String response = curl.exec(CUrl.UTF8, null);

        JSONObject obj = new JSONObject(response);

        Boolean success = obj.getBoolean("success");
        if(success == false){
            return -1;
        }

        return obj.getInt("result");
    }

    /**
     * Method to get the number of events
     *
     * @param token Token of the user
     * @return Number of events
     */
    public static int getNbEvents(String token){
        CUrl curl = new CUrl("https://cookorama.fr/api/events/count");
        Map<String, String> headersSent = new HashMap<String, String>();
        headersSent.put("Authorization", token);
        curl.headers(headersSent);
        curl.insecure();
        String response = curl.exec(CUrl.UTF8, null);

        JSONObject obj = new JSONObject(response);

        Boolean success = obj.getBoolean("success");
        if(success == false){
            return -1;
        }

        return obj.getInt("result");
    }

    /**
     * Method to get the number of products
     *
     * @param token Token of the user
     * @return Number of products
     */
    public static int getNbProducts(String token){
        CUrl curl = new CUrl("https://cookorama.fr/api/products/count");
        Map<String, String> headersSent = new HashMap<String, String>();
        headersSent.put("Authorization", token);
        curl.headers(headersSent);
        curl.insecure();
        String response = curl.exec(CUrl.UTF8, null);

        JSONObject obj = new JSONObject(response);

        Boolean success = obj.getBoolean("success");
        if(success == false){
            return -1;
        }

        return obj.getInt("result");
    }

}
