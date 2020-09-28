package com.example.Auto24Pluss.Controller;

import java.util.List;

public class SearchSave {
    private List<String> searchlink; //see on list, mille sisend on String.
                                    // kui oleks List<Users> user, siis see on list listis
    private Long userId;

    public List<String> getSearchlink() {
        return searchlink;
    }

    public void setSearchlink(List<String> searchlink) {
        this.searchlink = searchlink;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

  /*  public String getLink(){
        String host = "https://www.auto24.ee/";
        String path = "kasutatud/nimekiri.php?";

        String markTähis = "ac=";
        Long markId = 2;
        String link = "bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi";

        return host + path + markTähis + markId;
    }*/

