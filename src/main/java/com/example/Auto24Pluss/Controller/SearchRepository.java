package com.example.Auto24Pluss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
        String sql = "INSERT INTO searchresult (search_id, user_id, resultname, price, oldprice, linkurl) values(:searchId, 1, :name, :price, :oldprice, :link)";
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

    public List<Integer> getOldPrice(int oldPrice) {
        String sql = "SELECT oldprice from searchresult where linkurl = 'https://www.auto24.ee/used/3158937' and user_id = 1 and search_id = 1";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForList(sql, paramMap, Integer.class);

    }

    public void saveOldPrice(int searchId, int userId, int price, int oldPrice) {
        String sql = "INSERT INTO searchresult (search_id, user_id, price, oldprice) values(:searchId, 1, :price, :oldprice)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchId", searchId);
        paramMap.put("userId", userId);
        paramMap.put("price", price);
        paramMap.put("oldprice", oldPrice);
        jdbcTemplate.update(sql, paramMap);
    }

}
