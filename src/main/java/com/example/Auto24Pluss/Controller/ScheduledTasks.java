package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@EnableScheduling

@RestController


@Component
public class ScheduledTasks {
    @Autowired
    ContentReaderService contentReaderService;
    @Autowired
    AccountController accountController;
    @Autowired
    private AccountService accountService;



    @Scheduled(fixedDelay = 100000)
    public void saveHtml() {
        System.out.println("Save html started: " + LocalDateTime.now());
        accountService.saveHtml();
        System.out.println("Save html ended: " + LocalDateTime.now());

    }

  /*  @Scheduled(fixedRate = 10000000)
    public void saveSearchLinks() {
        accountService.searchLink();
    }*/


}





