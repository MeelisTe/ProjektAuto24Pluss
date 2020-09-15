package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void createNewAccount(String firstname, String lastname, String username, String password, String dob, String email){
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }
}
