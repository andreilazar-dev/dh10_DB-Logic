package com.dh10.access.model.dao;

import com.dh10.access.model.beans.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserDao extends DefaultDao implements Dao<User> {
    @Override
    public User get(String id) {
        return (User) super.get(User.class ,id);
    }

    @Override
    public List<User> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> all = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM User").list();
            for (Iterator iterator =users.iterator(); iterator.hasNext(); ) {
                all.add((User) iterator.next());
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
    public void save(User user) {
        super.save(user);
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List persons = session.createQuery("FROM User").list();
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
