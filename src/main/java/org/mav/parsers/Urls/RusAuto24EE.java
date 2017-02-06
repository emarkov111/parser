package org.mav.parsers.Urls;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class RusAuto24EE {
    private Document doc = null;

    public RusAuto24EE(String url) {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getDataSite() {
        Element table = doc.select("table").get(2); //select the first table.
        Elements rows = table.select("tr");
        ArrayList pictureAdres = new ArrayList();
        for (int i = 1; i < rows.size() - 1; i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Elements picture = row.getElementsByClass("small-image");
            for(Element p : picture) {
                pictureAdres.add(p.select("img").attr("src"));
//                System.out.println(picture);
            }
        }
        for (int i = 0; i < pictureAdres.size(); i++) {
//            System.out.println(pictureAdres.get(i));
        }

    }
}