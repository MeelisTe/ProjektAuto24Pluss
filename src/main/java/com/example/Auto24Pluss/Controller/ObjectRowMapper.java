package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper implements RowMapper<SearchLinkSave> {

    @Override
    public SearchLinkSave mapRow(ResultSet resultSet, int i) throws SQLException {
        SearchLinkSave savedresults = new SearchLinkSave();
        savedresults.setSearchlink(resultSet.getString("searchlink"));
        savedresults.setUserId(resultSet.getLong("user_id"));
        savedresults.setSearchId(resultSet.getLong("searchId"));

        return savedresults;
    }
}
