package org.mav.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Urls {

    public String getUrl() {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("/home/andrew/developer/projects/java/parser/src/main/java/org/mav/config/urls.json"));

            JSONArray jsonarray = (JSONArray) obj;
            Iterator iterator = jsonarray.iterator();
            while (iterator.hasNext()) {
                JSONObject t = (JSONObject) iterator.next();
                if (t.containsKey("url")) {
                    System.out.println(t.get("url"));
                }
                if (t.containsKey("method")) {
                    System.out.println(t.get("method"));
                }else{
                    System.out.println("GET");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String url = "http://rus.auto24.ee/kasutatud/nimekiri.php?bn=2&a=100&aj=&b=4&ae=2&af=200&ag=0&ag=1&otsi=поиск&ak=0";
        return url;
    }

}
