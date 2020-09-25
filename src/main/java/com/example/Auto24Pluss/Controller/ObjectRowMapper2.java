package com.example.Auto24Pluss.Controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class ObjectRowMapper2 implements RowMapper<SearchSave> {

    @Override
    public SearchSaveLink mapRow(ResultSet row, int i) throws SQLException {
        SearchSaveLink savedresults = new SearchSaveLink();
        savedresults.setSearchlink(Collections.singletonList(row.getString("searchlink"))); //''account_nr'' nimetus(väärtus) tuleb Postgre'st account tabelist. getString - võtame account nr'i väärtuse. resultSet anname ''accounts.setAccountNr'' accountNr'le väärtuse, ''accounts.setAccountNr'' annab väärtuse klassi BankAccount ''account_Nr'' muutujale
        savedresults.setUserId(row.getLong("user_id"));
        return savedresults;
    }
}
