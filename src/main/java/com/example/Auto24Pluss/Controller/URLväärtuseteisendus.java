package com.example.Auto24Pluss.Controller;

public class URLväärtuseteisendus {
    public static void main(String[] args) {
        String otsitavIndex = "&bw=";
        String a = "https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=18&bw=2149&ae=2&af=50&ag=0&ag=1&otsi=otsi";
        int bStartIndex = a.indexOf(otsitavIndex) + otsitavIndex.length();
        int bEndIndex = a.indexOf("&", bStartIndex);
        String bValue = a.substring(bStartIndex, bEndIndex);
        Integer bIntValue = Integer.valueOf(bValue);
        System.out.println(bIntValue);
    }
}
