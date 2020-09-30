package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

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
    final String adage = "&ad=";

    String hind = "<td class=\"price\">";
    String sõidukeid = "<span class=\"item\">1&ndash;";
    String link = "<td class=\"make_and_model\"><a href=\"/used/";
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private RestTemplate restTemplate;



    public void saveHtml() {
        List<SearchEntity> links = accountRepository.getLink(1);
        System.out.println("\n" + links.size() + "\n");
        for (SearchEntity s : links) {
// TODO
            // 1) tee andmebaasi päring ja saa kõik urlid
            // 2) tee tsükkel mis käib nii kaua kui palju päringuid (urle) on vaja teha

            // 3) tõsta vastuse töötlus eraldi alamfunktsiooni, et kood loetav oleks
            // 4) pane päringu tegemine ja vastuse töötlemine loodud tsükklisse

            String htmlString = restTemplate.getForObject(s.getLink(), String.class);
            //  String htmlString1 = restTemplate.getForObject("https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi", String.class);

            System.out.println("\n" + "Done" + "\n");

            int sõidukeidStartIndex = htmlString.indexOf(sõidukeid) + sõidukeid.length();
            int sõidukeidEndIndex = htmlString.indexOf("<", sõidukeidStartIndex);
            String sõidukeidkokku = htmlString.substring(sõidukeidStartIndex, sõidukeidEndIndex);
            int sõidukid = Integer.valueOf(sõidukeidkokku);
            System.out.println("Sõidukeid kokku: " + sõidukid + "\n");

            int i = 0;
            int lastIndex1 = 0;
            int lastIndex2 = 0;
            int lastIndex3 = 0;
            int userId = 0;
            int oldPrice = 0;


            while (i < sõidukid) { //hind loop

                int hindStartIndex = htmlString.indexOf(hind, lastIndex1) + hind.length();
                lastIndex1 = hindStartIndex + hind.length();
                int hindEndIndex = htmlString.indexOf("<", hindStartIndex);
                String hindValueString = htmlString.substring(hindStartIndex, hindEndIndex);
                hindValueString = hindValueString.replace("&nbsp;", "");
                int price = Integer.valueOf(hindValueString.trim());
                //    System.out.println(price);

                int linkStartIndex = htmlString.indexOf(link, lastIndex2) + link.length();
                lastIndex2 = linkStartIndex + link.length();
                int linkEndIndex = htmlString.indexOf("\">", linkStartIndex);
                String linkValueIdentifier = htmlString.substring(linkStartIndex, linkEndIndex);
                String linkUrl = "https://www.auto24.ee/used/" + linkValueIdentifier;
                //    System.out.println(linkUrl);

                int nimetusStartIndex = htmlString.indexOf("<td class=\"make_and_model\">", lastIndex3) + link.length();
                nimetusStartIndex = htmlString.indexOf(">", nimetusStartIndex) + 1;
                int nimetusEndIndex = htmlString.indexOf("</a>", nimetusStartIndex);
                lastIndex3 = nimetusEndIndex;
                String resultName = htmlString.substring(nimetusStartIndex, nimetusEndIndex);
                //    System.out.println(resultName);

                //    System.out.println("");

                searchRepository.saveHtml(s.getId(), userId, resultName, price, oldPrice, linkUrl);

                i++;
            }
        }
    }

    /*public void searchLink() {

        List<String> linkResultList = searchRepository.getSearchLink();
        System.out.println(linkResultList.size() + "\n");
        for (String s : linkResultList) {
            System.out.println(s);
        }
    }*/


    public void createNewAccount(String firstname, String lastname, String username, String password, String
            dob, String email) {
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }

    public void saveURL(List<String> searchlink, Long userId) {

            for (int i = 0; i < searchlink.size(); i++) {
  //            Selle lühem ja "parem" syntax võiks olla "for (String s : searchlink) {}, mida alustan iter-ga"
                accountRepository.saveURL(searchlink.get(i), 1L);
            }
            System.out.println(searchlink);
    }

    public void deleteSearch(Integer user_id, Integer searchId) {
        accountRepository.deleteSearch(1, searchId);
    }

    public List<SearchResultSave> showResults(Integer user_id, Integer searchId) {
        return accountRepository.showResults(1, searchId);
    }

    public void updateInformation(String password, String email) {
        accountRepository.updateInformation(password, email);
    }

    public List<SearchLinkSave> displayresults() {
        return accountRepository.displayresults();
    }

    public List<GetcarMarkResult> markResult(int user_id) {
        List<GetcarMarkResult> result = new ArrayList<>();
        List<SearchEntity> searchLinkList = accountRepository.getLink(user_id);
        for (SearchEntity searchEntity : searchLinkList) {
            String searchLink = searchEntity.getLink();
            GetcarMarkResult resultElement = new GetcarMarkResult();
            resultElement.setMark(accountRepository.getCarMake(findElementByCode(searchLink, autoMark)));
            resultElement.setMudel(accountRepository.getCarmodel(findElementByCode(searchLink, autoMudel)));
            resultElement.setKeretyyp(accountRepository.getKeretyyp(findElementByCode(searchLink, keretyyp)));
            resultElement.setAasta_alates(accountRepository.getAasta_alates(findElementByCode(searchLink, aastaAlates)));
            resultElement.setAasta_kuni(accountRepository.getAasta_kuni(findElementByCode(searchLink, aastaKuni)));
            resultElement.setHind_alates(accountRepository.getHind_alates(findElementByCode(searchLink, hindAlates)));
            resultElement.setHind_kuni(accountRepository.getHind_kuni(findElementByCode(searchLink, hindKuni)));
            resultElement.setVoimsus_alates(accountRepository.getVoimsus_alates(findElementByCode(searchLink, voimsusAlates)));
            resultElement.setVoimsus_kuni(accountRepository.getVoimsus_kuni(findElementByCode(searchLink, voimsusKuni)));
            resultElement.setLabisoit_alates(accountRepository.getLabisoit_alates(findElementByCode(searchLink, labisoitAlates)));
            resultElement.setLabisoit_kuni(accountRepository.getLabisoit_kuni(findElementByCode(searchLink, labisoitKuni)));
            resultElement.setVarv(accountRepository.getCarcolor(findElementByCode(searchLink, varv)));
            resultElement.setKutus(accountRepository.getCarfuel(findElementByCode(searchLink, kytus)));
            resultElement.setKaigukast(accountRepository.getTransmission(findElementByCode(searchLink, kaigukast)));
            resultElement.setVedav_sild(accountRepository.getVedavsild(findElementByCode(searchLink, vedavsild)));
            resultElement.setAsukoht(accountRepository.getAsukoht(findElementByCode(searchLink, asukoht)));
            resultElement.setMuuja(accountRepository.getMuuja(findElementByCode(searchLink, myyja)));
            resultElement.setKuulutuse_vanus(accountRepository.getKuulutusevanus(findElementByCode(searchLink, adage)));
            resultElement.setJarjesta(accountRepository.getJarjesta(findElementByCode(searchLink, jarjesta)));
            resultElement.setNaita(accountRepository.getNaita(findElementByCode(searchLink, naita)));
            resultElement.setOksjon(accountRepository.getOksjon(findElementByCode(searchLink, oksjon)));
            resultElement.setSearchId(searchEntity.getId());
            result.add(resultElement);

        }
        return result;
    }

    private Integer findElementByCode(String searchLink, String code) {
        int markStartindex = searchLink.indexOf(code);
        if (markStartindex == -1) {
            return null;
        }
        markStartindex += code.length();
        int markEndIndex = searchLink.indexOf("&", markStartindex);
        String markValue = searchLink.substring(markStartindex, markEndIndex);
        return Integer.valueOf(markValue);
    }

/*   public int searchSettings() {

            int mudelStartIndex = searchLink.indexOf(autoMudel) + autoMudel.length();
            int mudelEndIndex = searchLink.indexOf("&", mudelStartIndex);
            String mudelValue = searchLink.substring(mudelStartIndex, mudelEndIndex);
            Integer mudelIntValue = Integer.valueOf(mudelValue);
            System.out.println(mudelIntValue);

            int markStartindex = searchLink.indexOf(autoMark) + autoMark.length();
            int markEndIndex = searchLink.indexOf("&", markStartindex);
            String markValue = searchLink.substring(markStartindex, markEndIndex);
            Integer markIntValue = Integer.valueOf(markValue);
            System.out.println(markIntValue);

            int naitaStartindex = searchLink.indexOf(naita) + naita.length();
            int naitaEndIndex = searchLink.indexOf("&", naitaStartindex);
            String naitaValue = searchLink.substring(naitaStartindex, naitaEndIndex);
            Integer naitaIntValue = Integer.valueOf(naitaValue);
            System.out.println(naitaIntValue);

        return mudelIntValue + markIntValue + naitaIntValue;

        }*/


}



