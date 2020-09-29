package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

/*
      @PutMapping("saveurl")
      public void saveURL(@RequestBody List<SearchSave> save) {
          System.out.println("test");
          for (SearchSave searchSave : save) {
              if (searchSave.getSearchlink() != null && !searchSave.getSearchlink().isBlank()){
              accountService.saveURL(save.getSearchlink(), 1L);
          }
*/
    @PutMapping("saveurl")
    public void saveURL(@RequestBody SearchSave save) {

System.out.println("lalala");
        accountService.saveURL(save.getSearchlink(), 1L);
    }

    @PutMapping("updateinformation")
    public void updateInformation(@RequestBody AccountInfo request) {
        accountService.updateInformation(request.getPassword(), request.getEmail());
    }

    @GetMapping("displayresults")
    public List<SearchLinkSave> displayresults() {
        return accountService.displayresults();
    }

    @GetMapping("markResult")
    public List<GetcarMarkResult> markResult() {
        return accountService.markResult(1);
    }

    @DeleteMapping("deleteSearch/{searchId}")
    public void deleteSearch(@PathVariable Integer searchId) {
        accountService.deleteSearch(1, searchId);
    }
  /*  @PostMapping("/addRows")
    public void addRows(@RequestBody )*/
/*    @GetMapping("getLink")
    public String getLink(){
        return accountService.markResult(1);
    }*/

   /* @PutMapping("saveHtml")
    public void saveHtml(@RequestBody SearchResult searchResult) {
        accountService.saveHtml(searchResult.getPrice(), searchResult.getLink(), searchResult.getName());
    }*/
}