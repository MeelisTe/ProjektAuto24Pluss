package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
        String sql = "INSERT INTO user (firstname, lastname, username, password, dob, email) values (:firstname, :lastname, :username, :password, :dob, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstname", firstname);
        paramMap.put("lastname", lastname);
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("dob", dob);
        paramMap.put("email", email);
        jdbcTemplate.update(sql, paramMap);
    }
}
