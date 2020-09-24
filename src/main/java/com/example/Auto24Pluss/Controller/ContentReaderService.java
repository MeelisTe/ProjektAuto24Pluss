package com.example.Auto24Pluss.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContentReaderService {


    public List<SearchResult> readContent(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        Elements rows = document.select(".result-row");

        List<SearchResult> results = new ArrayList<SearchResult>();
        for (Element row : rows) {
            Element makeAndModelTag = row.select(".make_and_model a").first();
            String modelLink = makeAndModelTag.absUrl("href");
            String name = makeAndModelTag.html();

            Elements selected = row.select(".price");
            Element priceColumn = selected.first();
            String price = priceColumn.html();
            String parsedPrice = price.split("<")[0].trim().replace("&nbsp;", "");



            SearchResult result = new SearchResult();
            result.setName(name);
            result.setPrice(Integer.parseInt(parsedPrice));
            result.setLink(modelLink);

            results.add(result);

            System.out.println("\n" + name + "\n" + parsedPrice + "\n" + modelLink);

        }
        return results;

    }
}
