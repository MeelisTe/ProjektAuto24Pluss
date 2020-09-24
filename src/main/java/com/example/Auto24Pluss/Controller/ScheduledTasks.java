package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;


@EnableScheduling

@RestController


@Component
public class ScheduledTasks {
    @Autowired
    private AccountService accountService;

    @Autowired ContentReaderService contentReaderService;

    @Autowired AccountController accountController;

    SearchResult searchResult = new SearchResult();


    @Scheduled(fixedRate = 10000000)
    public void test() {
        accountService.saveHtml(searchResult.getSearchId(), searchResult.getUserId(), searchResult.getName(), searchResult.getPrice(), searchResult.getOldPrice(), searchResult.getLink());

      //  String link = "https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi";


     //   contentReaderService.readContent(link);
    }
}





