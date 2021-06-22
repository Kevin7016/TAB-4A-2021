package Ejercicios2p.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.*;

public class CountriesController 
{
    URL url;
    String uri = "https://gist.githubusercontent.com/Yizack/bbfce31e0217a3689c8d961a356cb10d/raw/107e0bdf27918adea625410af0d340e8fc1cd5bf/countries.json";
    List<Country> countries;

    public CountriesController() throws Exception {
        url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36 Edg/89.0.774.68");
        connection.setRequestMethod("GET");
        connection.setReadTimeout(60 * 3000);
        connection.setRequestProperty("content-type", "application/json");

        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
        String buffer = "";
        String response = "";
        while((buffer = reader.readLine())!=null) {
            response += buffer;
        }

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject object = (JSONObject) obj; 
        JSONArray array = (JSONArray) object.get("countries");
        ArrayList<Country> countries = new ArrayList<>();
        for(int i=0;i<array.size();i++) {
            JSONObject country = (JSONObject) array.get(i);
            Country c = new Country();
            c.setName_en((String)country.get("name_en"));
            c.setName_es((String)country.get("name_es"));
            c.setCode((String)country.get("code"));
            c.setDial_code((String)country.get("dial_code"));
            countries.add(c);
        }
        this.countries = countries;
    }

    public List<Country> list() {
        return this.countries;
    }
    
    public static void main(String args[]) {
        try { 

            CountriesController ctrl = new CountriesController();
            ctrl.list();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
class Countries {
    List<Country> countries;

    public void setCountries(List<Country> lst) {
        countries = lst;
    }

    public List<Country> getCountries() {
        return this.countries;
    }
}
