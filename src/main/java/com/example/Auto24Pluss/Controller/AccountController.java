package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("createaccount")
    public void createNewAccount(@RequestBody AccountInfo request){
        accountService.createNewAccount(request.getFirstname(), request.getLastname(), request.getUsername(), request.getPassword(), request.getDob(), request.getEmail());
    }
}
