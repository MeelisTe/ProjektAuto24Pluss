package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;


@EnableScheduling


@Component
public class ScheduledTasks {
    @Autowired
    private AccountService accountService;

    @Autowired ContentReaderService contentReaderService;


    @Scheduled(fixedRate = 10000000)
    public void test() throws IOException {
        accountService.saveHtml(hindValue, linkValue, nimetusValue);

        String link = "https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi";


     //   contentReaderService.readContent(link);
    }
}





