package com.example.Auto24Pluss.Controller;

public class SearchSave {
    private String searchlink;
    private Long userId;

    public String getSearchlink() {
        return searchlink;
    }

    public void setSearchlink(String searchlink) {
        this.searchlink = searchlink;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

  /*  public String getLink(){
        String host = "https://www.auto24.ee/";
        String path = "kasutatud/nimekiri.php?";

        String markTähis = "ac=";
        Long markId = 2;
        String link = "bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi";

        return host + path + markTähis + markId;
    }*/
}
