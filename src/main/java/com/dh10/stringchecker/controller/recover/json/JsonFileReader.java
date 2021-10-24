package com.dh10.stringchecker.controller.recover.json;

import com.dh10.stringchecker.model.Country;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {

    public List<Country> getListofCountry() {
        JSONParser parser = new JSONParser();
        List<Country> all = null;
        try {
            // get the file url, not working in JAR file.
            URL resource = getClass().getClassLoader().getResource("file.txt");
            Object obj = parser.parse(new FileReader("src/main/resources/json/countries.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray countriesList = (JSONArray) jsonObject.get("countries");

            all = new ArrayList<>();
            for (Object o : countriesList) {
                JSONObject contry = (JSONObject) o;
                //System.out.println(contry.get("country"));
                all.add(new Country((String) contry.get("country")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

}
