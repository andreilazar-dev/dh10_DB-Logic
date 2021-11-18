package com.dh10;

import com.dh10.access.model.beans.User;
import com.dh10.access.model.dao.Dao;
import com.dh10.access.model.dao.UserDao;
import com.dh10.stringchecker.CountryChecker;
import com.dh10.stringchecker.StringChecker;
import com.dh10.stringchecker.model.beans.Country;
import com.dh10.stringchecker.model.beans.Synonymus;
import com.dh10.stringchecker.model.dao.SynonymusDao;

import java.util.List;

public class DemoFiller {
    public static void main(String[] args) {

        System.out.println("Starting saving .....");
        StringChecker countrycheck = new CountryChecker();
        Dao<User> userDao = new UserDao();

        //Find word
        countrycheck.find_standard("Italizs");
        countrycheck.find_standard("Italiza");
        countrycheck.find_standard("Italizytt");
        countrycheck.find_standard("Ital");
        countrycheck.find_standard("Austra");
        countrycheck.find_standard("Arab");
        countrycheck.find_standard("Franc");
        countrycheck.find_standard("Germa");
        countrycheck.find_standard("Norveg");
        countrycheck.find_standard("Belgiums");
        countrycheck.find_standard("Italis");
        countrycheck.find_standard("Roman");
        countrycheck.find_standard("Bratil");
        countrycheck.find_standard("Cina");
        countrycheck.find_standard("Afganista");
        countrycheck.find_standard("Ita");
        countrycheck.find_standard("Itazt");
        countrycheck.find_standard("Cipras");
        countrycheck.find_standard("Astrisr");
        countrycheck.find_standard("Astriassr");
        countrycheck.find_standard("Itulu");

        //Not Find
        countrycheck.find_standard("Americt");
        countrycheck.find_standard("Ciprasns");
        countrycheck.find_standard("Lersta");

        //Manual Save

        com.dh10.stringchecker.model.dao.Dao<Synonymus> test = new SynonymusDao();

        test.save(new Synonymus("Italtryno","Manual", 0 , new Country("Italy")));
        test.save(new Synonymus("Francesch","Manual", 0 , new Country("France")));
        test.save(new Synonymus("Osterreich","Manual", 0 , new Country("Austria")));


        userDao.save(new User("Rei","Andrei","Lazar","Ital","1"));
        userDao.save(new User("Alex","Alessandro","Grecchi","Itals","1"));
        userDao.save(new User("Delga","Lorenzo","Del Gaudio","Italz","1"));
        userDao.save(new User("Dari","Dario","Guarino","Itasl","1"));

        System.out.println("End saving ......");
    }
}
