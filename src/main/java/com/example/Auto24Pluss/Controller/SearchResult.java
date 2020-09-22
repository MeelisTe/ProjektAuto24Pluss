package com.example.Auto24Pluss.Controller;

public class SearchResult {
    private String name;
    private String link;
    private int price;

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
