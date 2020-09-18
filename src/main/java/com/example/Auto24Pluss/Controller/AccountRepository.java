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

    public String getCarMake(int markIntValue) {
        String sql = "SELECT name from automargid where car_brand_id= :markIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("markIntValue", markIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    public String getCarmodel(int modelIntValue) {
        String sql = "SELECT model from models where model_id= :modelIntValue";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("modelIntValue", modelIntValue);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public String getLink(int user_id){
        String sql = "Select searchlink from search where user_id = :user_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }


}

