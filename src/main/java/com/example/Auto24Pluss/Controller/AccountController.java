package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("createaccount")
    public void createNewAccount(@RequestBody AccountInfo request){
        accountService.createNewAccount(request.getFirstname(), request.getLastname(), request.getUsername(), request.getPassword(), request.getDob(), request.getEmail());
    }

    @PutMapping("saveurl")
    public void saveURL(@RequestBody SearchSave save){
        accountService.saveURL(save.getUser_id(), save.getSearchlink());
    }
}
