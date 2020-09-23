package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class SearchRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void saveSearchResult (int searchId, String name, int price, String link) {
        String sql = "INSERT INTO searchresult (resultname, price, linkurl, search_id, user_id) values(:name, :price, :link, :searchId, 1)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("price", price);
        paramMap.put("link", link);
        paramMap.put("searchId", searchId);
        jdbcTemplate.update(sql, paramMap);
    }

    public int saveSearch (String link) {
        String sql = "INSERT INTO search (searchlink, user_id) values(:link, 1)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("link", link);
        int id = jdbcTemplate.update(sql, paramMap);
        return id;
    }

    public void searchResultsToTable (int hindValue, String linkValue, String nimetusValue) {
        String sql = "INSERT INTO searchresult (price, resultname, linkurl, user_id) values(:price, :name, :link, 1)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("price", hindValue);
        paramMap.put("name", nimetusValue);
        paramMap.put("link", linkValue);
        jdbcTemplate.update(sql, paramMap);
    }
}
