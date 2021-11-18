package com.dh10;

import com.dh10.stringchecker.CountryChecker;
import com.dh10.stringchecker.StringChecker;
import com.dh10.stringchecker.model.beans.Country;
import com.dh10.stringchecker.model.beans.Synonymus;
import com.dh10.stringchecker.model.dao.Dao;
import com.dh10.stringchecker.model.dao.SynonymusDao;

import java.util.List;

public class DemoStringChecker {

    public static void main(String[] args) {

        StringChecker countrycheck = new CountryChecker();
        String out = "";
       out = countrycheck.find_standard("Italizsss");
       System.out.println(out);

        Dao<Synonymus> test = new SynonymusDao();

        test.update(List.of(new Synonymus("Italiz","Modded", 0 , new Country("Italy"))));



        
    }
}
