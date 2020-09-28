package com.example.Auto24Pluss.Controller;

public class SearchLinkSave {
    private String searchlink;
    private Long userId;
    private Long searchId;

    public Long getSearchId() {return searchId; }

    public void setSearchId(Long searchId) {this.searchId = searchId; }

    public String getSearchlink() {return searchlink; }

    public void setSearchlink(String searchlink) {
        this.searchlink = searchlink;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
