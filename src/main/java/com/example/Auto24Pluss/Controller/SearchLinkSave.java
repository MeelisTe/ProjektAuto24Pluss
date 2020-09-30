package com.example.Auto24Pluss.Controller;

public class SearchLinkSave {
    private String searchlink;
    private Long userId;
    private Long searchId;
    private String linkUrl;
    private String resultName;
    private String price;

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

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
