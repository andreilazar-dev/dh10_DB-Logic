package com.dh10.stringchecker.controller.recover.db;

import com.dh10.stringchecker.model.beans.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.dh10.stringchecker.utils.DBaccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Countries implements StandardWords {
    @Override
    public List<String> getStandars() {

        DBaccess dBaccess = DBaccess.getInstance();
        SessionFactory factory = dBaccess.getFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List<String> countries_name = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List countries = session.createQuery("FROM Country").list();
            for (Iterator iterator = countries.iterator(); iterator.hasNext(); ) {
                Country country = (Country) iterator.next();
                countries_name.add(country.getCountry_name());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return countries_name;
    }
}
