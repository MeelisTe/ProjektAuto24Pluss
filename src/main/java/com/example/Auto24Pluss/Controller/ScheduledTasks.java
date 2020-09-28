package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

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



    @Scheduled(fixedRate = 10000000)
    public void saveHtml() {
        accountService.saveHtml();

    }

  /*  @Scheduled(fixedRate = 10000000)
    public void saveSearchLinks() {
        accountService.searchLink();
    }*/


}





