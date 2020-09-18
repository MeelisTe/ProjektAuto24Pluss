/*
package com.example.Auto24Pluss.Controller;


import java.sql.SQLOutput;

public class URLväärtuseteisendus {
    public static void main(String[] args) {
        String autoMudel = "&bw=";
        String autoMark = "&b=";
        String keretyyp = "&j=";
        String aastaAlates = "&f1=";
        String aastaKuni = "&f2=";
        String hindAlates = "&g1=";
        String hindKuni = "&g2=";
        String voimsusAlates = "&k1=";
        String voimsusKuni = "&k2=";
        String labisoitAlates = "&l1=";
        String labisoitKuni = "&l2=";
        String varv = "&n=";
        String kytus = "&h=";
        String kaigukast = "&i=";
        String vedavsild = "&p=";
        String asukoht = "&ab=";
        String myyja = "&ac=";
        String jarjesta = "&ae=";
        String naita = "&af=";
        String oksjon = "&by=";

        String a ="https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=7&n=25&i=2&ae=2&af=50&ag=0&ag=1&bl=1&otsi=otsi";

        int mudelStartIndex = a.indexOf(autoMudel) + autoMudel.length();
        int mudelEndIndex = a.indexOf("&", mudelStartIndex);
        String mudelValue = a.substring(mudelStartIndex, mudelEndIndex);
        Integer mudelIntValue = Integer.valueOf(mudelValue);
        System.out.println(mudelIntValue);

        int markStartindex = a.indexOf(autoMark) + autoMark.length();
        int markEndIndex = a.indexOf("&", markStartindex);
        String markValue = a.substring(markStartindex, markEndIndex);
        Integer markIntValue = Integer.valueOf(markValue);
        System.out.println(markIntValue);
        //        return "mudelIntValue" + "markIntValue";

    }
}

*/