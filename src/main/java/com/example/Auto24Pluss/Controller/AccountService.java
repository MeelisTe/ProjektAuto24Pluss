package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class AccountService {
    public static String displayresults;
    final String autoMudel = "&bw=";
    final String autoMark = "&b=";
    final String keretyyp = "&j=";
    final String aastaAlates = "&f1=";
    final String aastaKuni = "&f2=";
    final String hindAlates = "&g1=";
    final String hindKuni = "&g2=";
    final String voimsusAlates = "&k1=";
    final String voimsusKuni = "&k2=";
    final String labisoitAlates = "&l1=";
    final String labisoitKuni = "&l2=";
    final String varv = "&n=";
    final String kytus = "&h=";
    final String kaigukast = "&i=";
    final String vedavsild = "&p=";
    final String asukoht = "&ab=";
    final String myyja = "&ac=";
    final String jarjesta = "&ae=";
    final String naita = "&af=";
    final String oksjon = "&by=";
    @Autowired
    private AccountRepository accountRepository;

    public static void saveHtml() {
        {

            URL url;

            try {
                // get URL content

                String a = "https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi";
                url = new URL(a);
                URLConnection conn = url.openConnection();

                // open the stream and put it into BufferedReader
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    System.out.println(inputLine);
                }
                br.close();

                System.out.println("Done");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        SearchSave.searchLink();
    }

    public void createNewAccount(String firstname, String lastname, String username, String password, String dob, String email) {
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }

    public void saveURL(String searchlink, Long userId) {
        accountRepository.saveURL(searchlink, 1l);
    }

    public void updateInformation(String password, String email) {
        accountRepository.updateInformation(password, email);
    }

    public List<SearchSave> displayresults() {
        return accountRepository.displayresults();
    }

    public GetcarMarkResult markResult(int user_id) {


        String searchLink = accountRepository.getLink(user_id);

        int markStartindex = searchLink.indexOf(autoMark) + autoMark.length();
        int markEndIndex = searchLink.indexOf("&", markStartindex);
        String markValue = searchLink.substring(markStartindex, markEndIndex);
        Integer markIntValue = Integer.valueOf(markValue);

        GetcarMarkResult result = new GetcarMarkResult();
        result.setMark(accountRepository.getCarMake(markIntValue));
        return result;
    }

    public GetcarMarkResult modelResult(int user_id) {
        String searchLink = accountRepository.getLink(user_id);

        int mudelStartIndex = searchLink.indexOf(autoMudel) + autoMudel.length();
        int mudelEndIndex = searchLink.indexOf("&", mudelStartIndex);
        String modelValue = searchLink.substring(mudelStartIndex, mudelEndIndex);
        Integer modelIntValue = Integer.valueOf(modelValue);

        GetcarMarkResult result = new GetcarMarkResult();
        result.setMudel(accountRepository.getCarmodel(modelIntValue));
        return result;
    }


/*   public int searchSettings() {

            int mudelStartIndex = searchLink.indexOf(autoMudel) + autoMudel.length();
            int mudelEndIndex = searchLink.indexOf("&", mudelStartIndex);
            String mudelValue = searchLink.substring(mudelStartIndex, mudelEndIndex);
            Integer mudelIntValue = Integer.valueOf(mudelValue);
 //           System.out.println(mudelIntValue);

            int markStartindex = searchLink.indexOf(autoMark) + autoMark.length();
            int markEndIndex = searchLink.indexOf("&", markStartindex);
            String markValue = searchLink.substring(markStartindex, markEndIndex);
            Integer markIntValue = Integer.valueOf(markValue);
 //           System.out.println(markIntValue);

            int naitaStartindex = searchLink.indexOf(naita) + naita.length();
            int naitaEndIndex = searchLink.indexOf("&", naitaStartindex);
            String naitaValue = searchLink.substring(naitaStartindex, naitaEndIndex);
            Integer naitaIntValue = Integer.valueOf(naitaValue);
 //           System.out.println(naitaIntValue);

        return mudelIntValue + markIntValue + naitaIntValue;

        }*/


}
