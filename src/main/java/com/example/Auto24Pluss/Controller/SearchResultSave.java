package com.example.Auto24Pluss.Controller;

public class SearchResultSave {
    private String searchlink;
    private Long userId;
    private Long searchId;
    private String linkurl;
    private String resultname;
    private String price;
    private String oldprice;

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

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getResultname() {
        return resultname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }
}
