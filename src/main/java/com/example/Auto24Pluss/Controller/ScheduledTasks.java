package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling


@Component
public class ScheduledTasks {
    @Autowired
    private AccountService accountService;

    @Autowired ContentReaderService contentReaderService;


    @Scheduled(fixedRate = 10000000)
    public void test() {
     //   accountService.saveHtml();

        contentReaderService.readContent();
    }
}





