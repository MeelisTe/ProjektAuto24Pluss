package com.example.Auto24Pluss.Controller;

import java.util.List;

public class SearchSaveLink {
    private List<String> searchlink;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getSearchlink() {
        return searchlink;
    }

    public void setSearchlink(List<String> searchlink) {
        this.searchlink = searchlink;
    }
}
