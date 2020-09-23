package com.example.Auto24Pluss.Controller;

public class SearchResult {
    private int searchId;
    private int userId;
    private String name;
    private int price;
    private int oldPrice;
    private String link;
    private int resultId;

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

  /*  @Override
    public String toString() {
        return "\n" +
                "name = " + name + "\n" +
                "link = " + link + "\n" +
                "price = " + price + "\n";
    }*/
}
