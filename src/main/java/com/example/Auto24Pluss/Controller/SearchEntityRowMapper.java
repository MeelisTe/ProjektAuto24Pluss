package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEntityRowMapper implements RowMapper<SearchEntity> {
    @Override
    public SearchEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        SearchEntity searchEntity = new SearchEntity();
        searchEntity.setId(resultSet.getInt("id"));
        searchEntity.setLink(resultSet.getString("searchlink"));
        searchEntity.setUserId(resultSet.getInt("user_id"));
        return searchEntity;
    }
}
