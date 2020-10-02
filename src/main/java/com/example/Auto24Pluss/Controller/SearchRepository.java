package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class SearchRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

  /*  public void saveSearchResult (int searchId, String name, int price, String link) {
        String sql = "INSERT INTO searchresult (resultname, price, linkurl, search_id, user_id) values(:name, :price, :link, :searchId, 1)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("price", price);
        paramMap.put("link", link);
        paramMap.put("searchId", searchId);
        jdbcTemplate.update(sql, paramMap);
    }*/

   /* public int saveSearch(String link, int userId) {
        String sql = "INSERT INTO search (searchlink, user_id) values(:link, 0)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("link", link);
        int id = jdbcTemplate.update(sql, paramMap);
        return id;
    }*/

    public void saveHtml(int searchId, int userId, String resultName, int price, int oldPrice, String linkUrl) {
        String sql = "INSERT INTO searchresult (search_id, user_id, resultname, price, oldprice, linkurl) values(:searchId, :userId, :name, :price, :oldprice, :link)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchId", searchId);
        paramMap.put("userId", userId);
        paramMap.put("name", resultName);
        paramMap.put("price", price);
        paramMap.put("oldprice", oldPrice);
        paramMap.put("link", linkUrl);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<String> getSearchLink() {
        String sql = "SELECT searchLink from search";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForList(sql, paramMap, String.class);
    }

    public List<Integer> getOldPrice(int userId, int searchId, String linkUrl) {
        String sql = "SELECT oldprice from searchresult where linkurl = :linkUrl and user_id = :userId and search_id = :searchId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchId", searchId);
        paramMap.put("userId", userId);
        paramMap.put("linkUrl", linkUrl);
        return jdbcTemplate.queryForList(sql, paramMap, Integer.class);

    }

    public List<Integer> getPrice(int userId, int searchId, String linkUrl) {
        String sql = "SELECT price from searchresult where linkurl = :linkUrl and user_id = :userId and search_id = :searchId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchId", searchId);
        paramMap.put("userId", userId);
        paramMap.put("linkUrl", linkUrl);
        return jdbcTemplate.queryForList(sql, paramMap, Integer.class);

    }

    public Integer saveNewPrice(int price, int userId, int searchId, String linkUrl) {
        String sql = "UPDATE searchresult SET price = :price where linkurl = :linkUrl and user_id = :userId and search_id = :searchId ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("price", price);
        paramMap.put("searchId", searchId);
        paramMap.put("userId", userId);
        paramMap.put("linkUrl", linkUrl);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void saveEmailInfo(int userId, int searchresultId) {
        String sql = "INSERT INTO email (user_id, searchresult_id) values(1, :searchresultId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("searchresultId", searchresultId);
        jdbcTemplate.update(sql, paramMap);
    }

    public void emailSent(int sent) {
        String sql = "UPDATE email SET sent = :sent";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sent", sent);
        jdbcTemplate.update(sql, paramMap);
    }


}
