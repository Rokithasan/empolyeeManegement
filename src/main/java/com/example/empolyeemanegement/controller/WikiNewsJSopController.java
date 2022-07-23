
package com.example.empolyeemanegement.controller;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.repository.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WikiNewsJSopController implements Initializable {

    @FXML
    public TextArea viewTxtAreaID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            StringBuilder sb = new StringBuilder();

            // load Html DOM using Jsoup libary
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();

            // fetch all headline and links
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                // make a string to show in display
                sb.append(
                        String.format("%s\n\t%s\n\n", headline.attr("title"), headline.absUrl("href"))
                );
            }

            viewTxtAreaID.setText(sb.toString());
        }
        catch (IOException e) {
//            e.printStackTrace();
            viewTxtAreaID.setText("Something error please try again with proper internet connection");
        }
    }
}
