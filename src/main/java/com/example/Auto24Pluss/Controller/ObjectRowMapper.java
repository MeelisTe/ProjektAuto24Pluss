package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper implements RowMapper<SearchLinkSave> {

    @Override
    public SearchLinkSave mapRow(ResultSet resultSet, int i) throws SQLException {
        SearchLinkSave savedresults = new SearchLinkSave();
        savedresults.setSearchlink(resultSet.getString("searchlink"));
        //''account_nr'' nimetus(väärtus) tuleb Postgre'st account tabelist. getString - võtame account nr'i väärtuse.
        // resultSet anname ''accounts.setAccountNr'' accountNr'le väärtuse, ''accounts.setAccountNr'' annab väärtuse
        // klassi BankAccount ''account_Nr'' muutujale
        savedresults.setUserId(resultSet.getLong("user_id"));
        savedresults.setSearchId(resultSet.getLong("searchId"));

        return savedresults;
    }
}
