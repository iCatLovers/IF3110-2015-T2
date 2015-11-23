/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author visat
 */
public class ISConnector {
    private static final String CONTEXT_PATH = "http://localhost:8080/Identity_Service";

    private static JSONObject request(String servletPath, byte[] query) {
        JSONObject object = null;
        try {
            if (servletPath != null && !servletPath.startsWith("/"))
                servletPath = "/" + servletPath;
            URLConnection connection = new URL(CONTEXT_PATH + servletPath).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            try (OutputStream output = connection.getOutputStream()) {
                output.write(query);
            }
            StringBuilder builder = new StringBuilder();
            BufferedReader buf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String read;
            while ((read = buf.readLine()) != null)
                builder.append(read);
            object = (JSONObject)new JSONParser().parse(builder.toString());
        }
        catch (IOException | ParseException ex) {
            System.err.println(ex.getMessage());
        }
        return object;
    }

    public static JSONObject requestLogin(String email, String password) {
        JSONObject object = null;
        try {
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            String query = String.format(
                    "email=%s&password=%s",
                    URLEncoder.encode(email, charset),
                    URLEncoder.encode(password, charset));
            object = request("/auth", query.getBytes());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return object;
    }

    public static JSONObject requestAuth(String accessToken) {
        JSONObject object = null;
        try {
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            String query = String.format(
                    "auth=%s",
                    URLEncoder.encode(accessToken, charset));
            object = request("/auth", query.getBytes());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return object;
    }

    public static JSONObject requestLogin(String auth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
