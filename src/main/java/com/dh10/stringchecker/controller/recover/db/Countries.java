package com.dh10.stringchecker.controller.recover.db;

import com.dh10.stringchecker.model.beans.Country;
import com.dh10.stringchecker.model.dao.CountryDao;
import com.dh10.stringchecker.model.dao.Dao;

import java.util.ArrayList;

import java.util.List;

public class Countries implements StandardWords {
    @Override
    public List<String> getStandars() {
        List<String> countries_name = new ArrayList<>();

        Dao<Country> countryDao = new CountryDao();
        List<Country> all_country = countryDao.getAll();

        for(Country country : all_country){
            countries_name.add(country.getCountry_name());
        }
        return countries_name;
    }
}
