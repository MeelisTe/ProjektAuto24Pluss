package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper implements RowMapper<SearchSave> {

    @Override
    public SearchSave mapRow(ResultSet row, int i) throws SQLException {
        SearchSave savedresults = new SearchSave();
        savedresults.setSearchlink(row.getString("searchlink")); //''account_nr'' nimetus(väärtus) tuleb Postgre'st account tabelist. getString - võtame account nr'i väärtuse. resultSet anname ''accounts.setAccountNr'' accountNr'le väärtuse, ''accounts.setAccountNr'' annab väärtuse klassi BankAccount ''account_Nr'' muutujale
        savedresults.setUserId(row.getLong("user_id"));
        return savedresults;
    }
}
