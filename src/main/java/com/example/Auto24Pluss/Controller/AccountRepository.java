package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

}

