package org.mav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by andrew on 05.02.17.
 */
public class Parser {
    private Document doc = null;

    public Parser(String url) {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getTitle() {
        String title = doc.title();
        System.out.println(title);
        return title;
    }

    public void getTable() {
        Elements title = doc.getElementsByClass("display fpltable");
        System.out.println(title);
    }
}