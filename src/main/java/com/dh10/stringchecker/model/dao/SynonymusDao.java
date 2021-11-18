package com.dh10.stringchecker.model.dao;

import com.dh10.stringchecker.model.beans.Synonymus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SynonymusDao extends DefaultDao implements Dao<Synonymus> {
    @Override
    public Optional<Synonymus> get(String id) {
        return (Optional<Synonymus>) super.get(Synonymus.class,id);
    }

    @Override
    public List<Synonymus> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Synonymus> all = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List countries = session.createQuery("FROM Synonymus").list();
            for (Iterator iterator = countries.iterator(); iterator.hasNext(); ) {
                all.add((Synonymus) iterator.next());
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
    public void save(Synonymus synonymus) {
        if (get(Synonymus.class, synonymus.getSynonymus_name()) == null)
            super.save(synonymus);
    }

    @Override
    public void update(List<Synonymus> synonymus) {
        Session session = factory.openSession();
        Transaction tx = null;


        try {
            tx = session.beginTransaction();
            for (Synonymus val:synonymus) {
                session.update(val);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Synonymus synonymus) {

    }
}
