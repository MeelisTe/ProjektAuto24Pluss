package com.example.Auto24Pluss.Controller;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    public static String displayresults;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FuelRepository fuelRepository;


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


    @Autowired
    private RestTemplate restTemplate;

    String hind = "<td class=\"price\">";
    String sõidukeid = "<span class=\"item\">1&ndash;";

    String link = "<td class=\"make_and_model\"><a href=\"/used/";

    public void saveHtml() {
        String htmlString = restTemplate.getForObject("https://www.auto24.ee/kasutatud/nimekiri.php?bn=2&a=101102&aj=&b=247&ae=2&af=50&ag=0&ag=1&otsi=otsi", String.class);

        System.out.println(htmlString);

        System.out.println("");

        System.out.println("Done");

        System.out.println("");


        int sõidukeidStartIndex = htmlString.indexOf(sõidukeid) + sõidukeid.length();
        int sõidukeidEndIndex = htmlString.indexOf("<", sõidukeidStartIndex);
        String sõidukeidkokku = htmlString.substring(sõidukeidStartIndex, sõidukeidEndIndex);
        int sõidukid = Integer.valueOf(sõidukeidkokku);
        System.out.println("Sõidukeid kokku: " + sõidukeidkokku + "\n");

        int i = 0;
        int lastIndex = 0;

        while (i < sõidukid) { //hind loop

            int hindStartIndex = htmlString.indexOf(hind, lastIndex) + hind.length();
            lastIndex = hindStartIndex + hind.length();
            int hindEndIndex = htmlString.indexOf("<", hindStartIndex);
            String hindValue = htmlString.substring(hindStartIndex, hindEndIndex);
            hindValue = hindValue.replace("&nbsp;", "");
            System.out.println(hindValue);
            i++;

        }

        System.out.println("");

        lastIndex = 0;
        i = 0;

        while (i < sõidukid) { // link loop

            int linkStartIndex = htmlString.indexOf(link, lastIndex) + link.length();
            lastIndex = linkStartIndex + link.length();
            int linkEndIndex = htmlString.indexOf("\">", linkStartIndex);
            String linkValue = htmlString.substring(linkStartIndex, linkEndIndex);
            System.out.println("https://www.auto24.ee/used/" + linkValue);
            i++;

        }

        System.out.println("");

        lastIndex = 0;
        i = 0;

        while (i < sõidukid) { //nimetus loop

            int nimetusStartIndex = htmlString.indexOf("<td class=\"make_and_model\">", lastIndex) + link.length();
            nimetusStartIndex = htmlString.indexOf(">", nimetusStartIndex) + 1;
            int nimetusEndIndex = htmlString.indexOf("</a>", nimetusStartIndex);
            lastIndex = nimetusEndIndex;
            String nimetusValue = htmlString.substring(nimetusStartIndex, nimetusEndIndex);
            System.out.println(nimetusValue);
            i++;
        }

    }


    public void createNewAccount(String firstname, String lastname, String username, String password, String dob, String email) {
        accountRepository.createNewAccount(firstname, lastname, username, password, dob, email);
    }

    public void saveURL(List<String> searchlink, Long userId) {

            for (int i = 0; i < searchlink.size(); i++) {
  //            Selle lühem ja "parem" syntax võiks olla "for (String s : searchlink) {}, mida alustan iter-ga"
                accountRepository.saveURL(searchlink.get(i), 1L);
            }
            System.out.println(searchlink);
    }

    public void deleteSearch(Integer user_id) {
        accountRepository.deleteSearch(1);
    }

    public void updateInformation(String password, String email) {
        accountRepository.updateInformation(password, email);
    }

 /*   public List<SearchSave> displayresults() {
        return accountRepository.displayresults();
    }*/

    public GetcarMarkResult markResult(int user_id) {
        List<String> searchLink = accountRepository.getLink(user_id);
        GetcarMarkResult result = new GetcarMarkResult();
        result.setMark(accountRepository.getCarMake(findElementByCode(String.valueOf(searchLink), autoMark)));
        result.setMudel(accountRepository.getCarmodel(findElementByCode(String.valueOf(searchLink), autoMudel)));
        result.setKeretyyp(accountRepository.getKeretyyp(findElementByCode(String.valueOf(searchLink), keretyyp)));
        result.setAasta_alates(findElementByCode(String.valueOf(searchLink), aastaAlates));
        result.setAasta_kuni(findElementByCode(String.valueOf(searchLink), aastaKuni));
        result.setHind_alates(findElementByCode(String.valueOf(searchLink), hindAlates));
        result.setHind_kuni(findElementByCode(String.valueOf(searchLink), hindKuni));
        result.setVoimsus_alates(findElementByCode(String.valueOf(searchLink), voimsusAlates));
        result.setVoimsus_kuni(findElementByCode(String.valueOf(searchLink), voimsusKuni));
        result.setLabisoit_alates(findElementByCode(String.valueOf(searchLink), labisoitAlates));
        result.setLabisoit_kuni(findElementByCode(String.valueOf(searchLink), labisoitKuni));
        result.setVarv(accountRepository.getCarcolor(findElementByCode(String.valueOf(searchLink), varv)));
        result.setKutus(accountRepository.getCarfuel(findElementByCode(String.valueOf(searchLink), kytus)));
        result.setKaigukast(accountRepository.getTransmission(findElementByCode(String.valueOf(searchLink), kaigukast)));
        result.setVedav_sild(accountRepository.getVedavsild(findElementByCode(String.valueOf(searchLink), vedavsild)));
        result.setAsukoht(accountRepository.getAsukoht(findElementByCode(String.valueOf(searchLink), asukoht)));
        result.setMuuja(accountRepository.getMuuja(findElementByCode(String.valueOf(searchLink), myyja)));
        result.setKuulutuse_vanus(accountRepository.getKuulutusevanus(findElementByCode(String.valueOf(searchLink), adage)));
        result.setJarjesta(accountRepository.getJarjesta(findElementByCode(String.valueOf(searchLink), jarjesta)));
        result.setNaita(accountRepository.getNaita(findElementByCode(String.valueOf(searchLink), naita)));
        result.setOksjon(accountRepository.getOksjon(findElementByCode(String.valueOf(searchLink), oksjon)));
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



