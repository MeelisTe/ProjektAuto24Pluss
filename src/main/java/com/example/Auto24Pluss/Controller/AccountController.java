package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("createaccount")
    public void createNewAccount(@RequestBody AccountInfo request) {
        accountService.createNewAccount(request.getFirstname(), request.getLastname(), request.getUsername()
                , request.getPassword(), request.getDob(), request.getEmail());
    }


  /*  @PutMapping("saveurl")
    public void saveURL(@RequestBody List<SearchSave> save) {
        System.out.println("test");
        for (SearchSave searchSave : save) {
            if (searchSave.getSearchlink() != null && !searchSave.getSearchlink().isBlank())
        }
    }*/
    @PutMapping("saveurl")
    public void saveURL(@RequestBody SearchSave save) {
        accountService.saveURL(save.getSearchlink(), 1l);
    }

    @PutMapping("updateinformation")
    public void updateInformation(@RequestBody AccountInfo request) {
        accountService.updateInformation(request.getPassword(), request.getEmail());
    }

    @GetMapping("displayresults")
    public List<SearchSave> displayresults() {
        return accountService.displayresults();
    }

   @GetMapping("markResult")
    public GetcarMarkResult markResult(){
        return accountService.markResult(1);
    }
/*    @GetMapping("getLink")
    public String getLink(){
        return accountService.markResult(1);
    }*/
}