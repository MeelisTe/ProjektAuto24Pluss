package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createNewAccount(String firstname, String lastname, String username, String password, String dob, String email) {
        String sql = "INSERT INTO appuser (firstname, lastname, username, password, dob, email) values (:firstname, :lastname, :username, :password, :dob, :email)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("firstname", firstname);
        paramMap.put("lastname", lastname);
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("dob", dob);
        paramMap.put("email", email);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer user_id(String username) {
        String sql = "SELECT id FROM appuser WHERE username = :username";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void saveURL(String searchlink, Integer userId) {
        String sql = "INSERT INTO search (searchlink, user_id) values (:searchlink, :userId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchlink", searchlink);
        paramMap.put("userId", userId);

        jdbcTemplate.update(sql, paramMap);
    }

    public void updateInformation(String password, String email) {
        String sql = "UPDATE appuser SET password= :password and email= :email WHERE id= :1";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("password", password);
        paramMap.put("email", email);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<SearchLinkSave> displayresults() {
        String sql = "SELECT * FROM search";
        return jdbcTemplate.query(sql, new HashMap<>(), new ObjectRowMapper());
    }

    public void deleteSearch(Integer user_id, Integer searchId) {
        String sql = "DELETE from searchresult where user_id = :user_id and search_id = :searchId";
        String sql1 = "DELETE FROM search where user_id = :user_id and id = :searchId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        paramMap.put("searchId", searchId);
        jdbcTemplate.update(sql, paramMap);
        jdbcTemplate.update(sql1, paramMap);
    }
    public List<SearchResultSave> showResults (Integer user_id, Integer searchId) {
        String sql = "SELECT resultname, price, oldprice, linkurl from searchresult where user_id = :user_id and search_id = :searchId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        paramMap.put("searchId", searchId);
        return jdbcTemplate.query(sql, paramMap, new SearchRowMapper());
    }

/*    public List<SearchEntity> getLink(int user_id) {

        String sql = "Select id, searchlink from search where user_id = :user_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        return jdbcTemplate.query(sql, paramMap, new SearchEntityRowMapper());
    }*/

    public String getCarMake(Integer markIntValue) {
        if (markIntValue == null) {
            return "-";
        }
        String sql = "SELECT name from automargid where car_brand_id= :markIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("markIntValue", markIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getCarmodel(Integer modelIntValue) { //null väärtus saab olla ainult Integeril (int ei tööta)
        if (modelIntValue == null) {
            return "-";
        }
        String sql = "SELECT model from models where model_id= :modelIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("modelIntValue", modelIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public Object getAasta_alates(Integer aasta_alatesIntValue) {
        if (aasta_alatesIntValue == null) {
            return "-";
        }
        return aasta_alatesIntValue;
    }
    public Object getAasta_kuni(Integer aasta_kuniIntValue) {
        if (aasta_kuniIntValue == null) {
            return "-";
        }
        return aasta_kuniIntValue;
    }
    public Object getHind_alates(Object hind_alatesIntValue) {
        if (hind_alatesIntValue == null) {
            return "-";
        }
        return hind_alatesIntValue;
    }
    public Object getHind_kuni(Object hind_kuniIntValue) {
        if (hind_kuniIntValue == null) {
            return "-";
        }
        return hind_kuniIntValue;
    }
    public Object getVoimsus_alates(Object voimsus_alatesIntValue) {
        if (voimsus_alatesIntValue == null) {
            return "-";
        }
        return voimsus_alatesIntValue;
    }
    public Object getVoimsus_kuni(Object voimsus_kuniIntValue) {
        if (voimsus_kuniIntValue == null) {
            return "-";
        }
        return voimsus_kuniIntValue;
    }
    public Object getLabisoit_alates(Object labisoit_alatesIntValue) {
        if (labisoit_alatesIntValue == null) {
            return "-";
        }
        return labisoit_alatesIntValue;
    }
    public Object getLabisoit_kuni(Object labisoit_kuniIntValue) {
        if (labisoit_kuniIntValue == null) {
            return "-";
        }
        return labisoit_kuniIntValue;
    }
    public String getKeretyyp(Integer typeIntValue) {
        if (typeIntValue == null) {
            return "-";
        }
        String sql = "SELECT bodytype from bodytypes where car_bodytype_id= :typeIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("typeIntValue", typeIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public List<Object> getSearchId(String searchlinkIntValue) {
        String sql = "SELECT id from search where searchlink= :searchlinkIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchlinkIntValue", searchlinkIntValue);
        return jdbcTemplate.queryForList(sql, paramMap, Object.class);
    }
    public String getCarcolor(Integer colorIntValue) {
        if (colorIntValue == null) {
            return "-";
        }
        String sql = "SELECT color from colors where car_color_id= :colorIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("colorIntValue", colorIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getCarfuel(Integer fuelIntValue) {
        if (fuelIntValue == null) {
            return "-";
        }
        String sql = "SELECT fuel from fuels where car_fuel_id= :fuelIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fuelIntValue", fuelIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getTransmission(Integer transmissionIntValue) {
        if (transmissionIntValue == null) {
            return "-";
        }
        String sql = "SELECT transmission from transmissions where car_transmission_id= :transmissionIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("transmissionIntValue", transmissionIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getVedavsild(Integer vedavsildIntValue) {
        if (vedavsildIntValue == null) {
            return "-";
        }
        String sql = "SELECT vedavsild from vedavsilds where car_vedavsild_id= :vedavsildIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vedavsildIntValue", vedavsildIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getAsukoht(Integer asukohtIntValue) {
        if (asukohtIntValue == null) {
            return "-";
        }
        String sql = "SELECT location from locations where car_location_id= :asukohtIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("asukohtIntValue", asukohtIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getMuuja(Integer myyjaIntValue) {
        if (myyjaIntValue == null) {
            return "-";
        }
        String sql = "SELECT seller from sellers where car_seller_id= :myyjaIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("myyjaIntValue", myyjaIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getJarjesta(Integer jarjestaIntValue) {
        if (jarjestaIntValue == null) {
            return "-";
        }
        String sql = "SELECT sort from sorts where car_sort_id= :jarjestaIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jarjestaIntValue", jarjestaIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getNaita(Integer naitaIntValue) {
        if (naitaIntValue == null) {
            return "-";
        }
        String sql = "SELECT show from shows where car_show_id= :naitaIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("naitaIntValue", naitaIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getOksjon(Integer oksjonIntValue) {
        if (oksjonIntValue == null) {
            return "-";
        }
        String sql = "SELECT auction from auctions where car_auction_id= :oksjonIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("oksjonIntValue", oksjonIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getKuulutusevanus(Integer kuulutusevanusIntValue) {
        if (kuulutusevanusIntValue == null) {
            return "-";
        }
        String sql = "SELECT adage from adages where car_adage_id= :kuulutusevanusIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kuulutusevanusIntValue", kuulutusevanusIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public List<SearchEntity> getLink() {

        String sql = "Select id, user_id, searchlink from search";
        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("user_id", user_id);
        return jdbcTemplate.query(sql, paramMap, new SearchEntityRowMapper());
    }

    public List<SearchEntity> getLinkByUser(Integer userId) {
        String sql = "Select id, user_id, searchlink from search where user_id = :user_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", userId);
        return jdbcTemplate.query(sql, paramMap, new SearchEntityRowMapper());
    }

    public String getUser(String username) {
        String sql = "Select password from appuser where username= :username";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
}
