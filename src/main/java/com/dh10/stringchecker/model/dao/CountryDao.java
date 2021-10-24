package com.dh10.stringchecker.model.dao;

import com.dh10.stringchecker.model.beans.Bean;
import com.dh10.stringchecker.model.beans.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CountryDao extends DefaultDao implements Dao<Country> {
    @Override
    public Optional<Country> get(long id) {
        return (Optional<Country>) super.get(Country.class, id);
    }

    @Override
    public List<Country> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Country> all = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List countries = session.createQuery("FROM Country").list();
            for (Iterator iterator = countries.iterator(); iterator.hasNext(); ) {
                all.add((Country) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }

    @Override
    public void save(Country country) {
        super.save(country);
    }

    @Override
    public void update(Country country, String[] params) {

    }

    @Override
    public void delete(Country country) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List persons = session.createQuery("FROM Country").list();
            session.delete(country);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
