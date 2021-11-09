package com.dh10.stringchecker.model.dao;

import com.dh10.stringchecker.model.beans.Bean;
import com.dh10.utils.DBaccess;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public abstract class DefaultDao {
    DBaccess dBaccess = DBaccess.getInstance();
    SessionFactory factory = dBaccess.getFactory();

    void save(Bean bean) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(bean);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
           e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Object get(Class<? extends Bean> class1, String id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Object o = null;
        try {
            tx = session.beginTransaction();
            o = session.get(class1, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return o;
    }
}
