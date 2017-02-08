package org.mav;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 */
public class ProxyFile {
    private Document doc = null;
    private FileWriter file = null;
    private Connection.Method method;

    public ProxyFile(String url) {
        try {
            method = Connection.Method.POST;
            doc = Jsoup.connect(url)./*proxy("207.244.68.197",8080).*/method(method).get();
            file = new FileWriter("/home/andrew/developer/projects/java/parser/proxy.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getProxyFile() {
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
        JSONObject obj = new JSONObject();
        JSONArray proxyUrl = new JSONArray();
        for (int i = 1; i < rows.size() - 1; i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
//            obj.put(cols.get(0).text(), cols.get(1).text());

            proxyUrl.add(cols.get(0).text());
            proxyUrl.add(cols.get(1).text());

            obj.put("proxyUrl", proxyUrl);
        }
        try {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProxy() {
        getProxyFile();

        JSONParser parser = new JSONParser();
        String[] urlArray;
        String result = "";
        try {
            Object obj = parser.parse(new FileReader("/home/andrew/developer/projects/java/parser/proxy.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.toJSONString());

            JSONArray msg = (JSONArray) jsonObject.get("proxyUrl");
            String url = "";
            String port = "";
            urlArray = new String[msg.size()];
            for (int i = 0; i < msg.size(); i++) {
                if (i % 2 == 0) {
                    url = msg.get(i).toString();
                } else {
                    port = msg.get(i).toString();
                }
                urlArray[i] = url + ":" + port;
            }
            Random random = new Random();
            result = urlArray[random.nextInt(msg.size())];
/*            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                //               System.out.println(iterator.next());
            }
            */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    ;
}