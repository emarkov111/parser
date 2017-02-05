package org.mav;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 */
public class Parser {
    private Document doc = null;
    private FileWriter file = null;

    public Parser(String url) {
        try {
            doc = Jsoup.connect(url).get();
            file = new FileWriter("/home/andrew/developer/projects/java/parser/proxy.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        String title = doc.title();
        return title;
    }

    public void getProxyFile() {
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
        JSONObject obj = new JSONObject();
        for (int i = 1; i < rows.size() - 1; i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            obj.put(cols.get(0).text(), cols.get(1).text());
        }
        try {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}