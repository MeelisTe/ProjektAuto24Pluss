package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRowMapper implements RowMapper<SearchResultSave> {

    @Override
    public SearchResultSave mapRow(ResultSet resultSet, int i) throws SQLException {
        SearchResultSave savedsearchresults = new SearchResultSave();
        savedsearchresults.setResultname(resultSet.getString("resultname"));
        savedsearchresults.setPrice(resultSet.getString("price"));
        savedsearchresults.setOldprice(resultSet.getString("oldprice"));
        savedsearchresults.setLinkurl(resultSet.getString("linkurl"));
        return savedsearchresults;
    }
}