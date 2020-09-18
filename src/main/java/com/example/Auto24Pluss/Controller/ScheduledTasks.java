package com.example.Auto24Pluss.Controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling


@Component

public class ScheduledTasks {
    @Scheduled(fixedRate = 1000000)
    public void test() {
        AccountService.saveHtml();
    }
}





