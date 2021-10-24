package com.dh10.stringchecker.controller.recover.json;

import com.dh10.stringchecker.model.beans.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.dh10.stringchecker.utils.DBaccess;

import java.util.List;

public class Filler {

    /* Method to CREATE an country in the database */
    public boolean addCountries() {

        DBaccess dBaccess = DBaccess.getInstance();
        SessionFactory factory = dBaccess.getFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        Integer personID = null;

        List<Country> countries = new JsonFileReader().getListofCountry();

        try {
            tx = session.beginTransaction();
            for (Country contry : countries) {
                session.save(contry);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
