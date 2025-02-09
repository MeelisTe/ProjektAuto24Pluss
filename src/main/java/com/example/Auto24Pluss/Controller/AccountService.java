package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
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

    public List<GetcarMarkResult> markResult(String userName){
        Integer userId = accountRepository.user_id(userName);
        List<GetcarMarkResult> result = new ArrayList<>();
        List<SearchEntity> searchLinkList = accountRepository.getLinkByUser(userId);
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

    public void saveURL(List<String> searchlink, String username) {

        for (int i = 0; i < searchlink.size(); i++) {
            //            Selle lühem ja "parem" syntax võiks olla "for (String s : searchlink) {}, mida alustan iter-ga"
            accountRepository.saveURL(searchlink.get(i), accountRepository.user_id(username));
        }
        System.out.println(searchlink);
    }

    public void saveHtml() {
        List<SearchEntity> links = accountRepository.getLink();
        System.out.println("\n" + "Kasutaja salvestatud linkide arv: " + links.size() + "\n");
        for (SearchEntity s : links) {
// TODO
            // 1) tee andmebaasi päring ja saa kõik urlid
            // 2) tee tsükkel mis käib nii kaua kui palju päringuid (urle) on vaja teha

            // 3) tõsta vastuse töötlus eraldi alamfunktsiooni, et kood loetav oleks
            // 4) pane päringu tegemine ja vastuse töötlemine loodud tsükklisse
            System.out.println("Request to auto24 started: " + LocalDateTime.now());
            String htmlString = restTemplate.getForObject(s.getLink(), String.class);
            System.out.println("Request to auto24 ended: " + LocalDateTime.now());

            System.out.println("\n" + "Done" + "\n");

            int sõidukeidStartIndex = htmlString.indexOf(sõidukeid) + sõidukeid.length();
            int sõidukeidEndIndex = htmlString.indexOf("<", sõidukeidStartIndex);
            String sõidukeidkokku = htmlString.substring(sõidukeidStartIndex, sõidukeidEndIndex);
            int sõidukid = Integer.valueOf(sõidukeidkokku);
            System.out.println("Sõidukeid otsingus kokku: " + sõidukid + "\n");

            int i = 0;
            int lastIndex1 = 0;
            int lastIndex2 = 0;
            int lastIndex3 = 0;
            int oldPrice;

            System.out.println("Parse html started: " + LocalDateTime.now());
            while (i < sõidukid) {

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


                List<Integer> oldPriceList = searchRepository.getOldPrice(s.getUserId(),s.getId() , linkUrl);

                if (oldPriceList.isEmpty()) {
                    oldPrice = price;
                    searchRepository.saveHtml(s.getId(), s.getUserId(), resultName, price, oldPrice, linkUrl);
                } else {
                    oldPrice = oldPriceList.get(0);
                    Integer searchResultId = searchRepository.saveNewPrice(price, s.getUserId(), s.getId(), linkUrl);
                    if (price != oldPrice) {
                        searchRepository.saveEmailInfo(s.getUserId(), searchResultId);
                    } else{
                    }
                }
                i++;

            }
        }
    }

    // TODO

    public void sendEmail(int searchresultId, String linkUrl) {


    }


    public void createNewAccount(String firstname, String lastname, String username, String password, String
            dob, String email) {
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }



    public void deleteSearch(String username, Integer searchId) {
        accountRepository.deleteSearch(accountRepository.user_id(username), searchId);
    }

    public List<SearchResultSave> showResults(String username, Integer searchId) {
        return accountRepository.showResults(accountRepository.user_id(username), searchId);
    }

    public void updateInformation(String password, String email) {
        accountRepository.updateInformation(password, email);
    }

    public List<SearchLinkSave> displayresults() {
        return accountRepository.displayresults();
    }



}



