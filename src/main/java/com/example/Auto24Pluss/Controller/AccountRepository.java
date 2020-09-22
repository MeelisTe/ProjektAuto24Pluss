package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.bcs.valiit.controller.ObjectRowMapper;

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

    public String getUsernameByUserId(String kasutajanimi) {
        String sql = "SELECT id FROM appuser WHERE username = :kasutajaNimi";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("kasutajaNimi", kasutajanimi);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public void saveURL(String searchlink, Long userId) {
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

    public List<SearchSave> displayresults() {
        String sql = "SELECT * FROM search";
        return jdbcTemplate.query(sql, new HashMap<>(), new ObjectRowMapper());
    }

    public void deleteSearch(Integer user_id) {
        String sql = "DELETE FROM search where user_id = :user_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        jdbcTemplate.update(sql, paramMap);
    }

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

    public String getKeretyyp(Integer typeIntValue) {
        if (typeIntValue == null) {
            return "-";
        }
        String sql = "SELECT bodytype from bodytypes where car_bodytype_id= :typeIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("typeIntValue", typeIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
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

    public String getLink(int user_id) {

        String sql = "Select searchlink from search where user_id = :user_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }


}
