package fr.cookorama.dashboard;

import org.json.*;

import com.roxstudio.utils.CUrl;

/**
 * Class to get the token of the user
 *
 * @see Token
 */

public class Token {

    /**
     * Method to get the token of the user
     *
     * @param email Email of the user
     * @param password Password of the user
     * @return Token of the user
     */
    public static String getToken(String email, String password) {

        CUrl curl = new CUrl("https://cookorama.fr/api/user/connect");
        String jsonPayload = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";
        curl.opt("-X", "POST");
        curl.data(jsonPayload);
        curl.insecure();
        String response = curl.exec(CUrl.UTF8, null);

        JSONObject obj = new JSONObject(response);

        Boolean success = obj.getBoolean("success");
        if(success == false){
            return "-1";
        }
        String token = obj.getString("token");
        JSONObject data = obj.getJSONObject("data");
        int rights = data.getInt("rights");

        if(rights == 5){
            return token;
        } else {
            return "-2";
        }
    }
}