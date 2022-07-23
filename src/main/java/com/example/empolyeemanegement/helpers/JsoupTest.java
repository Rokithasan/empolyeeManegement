package com.example.empolyeemanegement.helpers;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.rmi.server.LogStream.log;

public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document doc =
                Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
//        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s\n", headline.attr("title"), headline.absUrl("href"));
        }
    }
}
