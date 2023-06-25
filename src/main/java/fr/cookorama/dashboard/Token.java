package fr.cookorama.dashboard;

import org.json.*;

import com.roxstudio.utils.CUrl;

public class Token {
    public static String getToken(String email, String password) {

        CUrl curl = new CUrl("http://localhost/api/user/connect");
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