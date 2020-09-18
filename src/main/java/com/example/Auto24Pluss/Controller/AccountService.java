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
    @Autowired
    private AccountRepository accountRepository;

    public void createNewAccount(String firstname, String lastname, String username, String password, String dob, String email) {
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }

    public void saveURL(String searchlink, Long userId) {
        accountRepository.saveURL(searchlink, userId);
    }

    public void updateInformation(String password, String email) {
        accountRepository.updateInformation(password, email);
    }

    public List<SearchSave> displayresults() {
        return accountRepository.displayresults();
    }

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

        }SearchSave.searchLink();
    }

}
