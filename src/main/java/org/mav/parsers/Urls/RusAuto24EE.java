package org.mav.parsers.Urls;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/*
* f1= год начало
* f2= год конец
* b= марка машины
* ak=0 с какой позиции начинаем показывать
* af=200 по какую позицию показываем
* g1=100 цена начало
* g2=10000 цена конец
* */
public class RusAuto24EE {
    private Document doc = null;

    public RusAuto24EE(String url, String userAgent) {
        try {
            doc = Jsoup.connect(url).method(Connection.Method.POST).userAgent(userAgent).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getDataSite() {
        Element table = doc.select("table").get(2); //select the first table.
        Elements rows = table.select("tr");
        ArrayList pictureAdres = new ArrayList();

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
//            Elements cols = row.select("td");
//            System.out.println(row);
/*picture*/
            Elements picture = row.getElementsByClass("small-image");
            for(Element p : picture) {
                pictureAdres.add(p.select("img").attr("src"));
//                System.out.println(picture);
            }
/*year*/
            Elements year = row.getElementsByClass("year");
//            System.out.println(year.text());
/*price*/
            Elements price = row.getElementsByClass("price");
//            System.out.println(price.text());
/*name*/
            Elements nameCar = row.getElementsByClass("make_and_model");
            for (Element nC: nameCar) {
                Elements linkNC =nC.getElementsByAttribute("href");
//                System.out.println(linkNC);
//                System.out.println(linkNC.text());
            }
/*select marka car http: id b = e.attr("value")*/
            Elements link = doc.select("#searchParam-cmm-1-make >option");
            for(Element e: link) {
//                System.out.println(e.attr("value") + " " + e.text());
            }
        }
/*next pages*/
        Elements nextPage = doc.getElementsByClass("input-link item");
//        System.out.println(nextPage.attr("href"));

        for (int i = 0; i < pictureAdres.size(); i++) {
//            System.out.println(pictureAdres.get(i));
        }
        System.out.println(pictureAdres.size());

    }
}