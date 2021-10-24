package com.dh10.stringchecker.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DBaccess {

    private static DBaccess dbAccess = null;
    private static SessionFactory factory;

    private DBaccess() {
    }

    public static DBaccess getInstance() {
        if (dbAccess == null) {
            dbAccess = new DBaccess();

            System.out.println("Creating Session Factory........... ");
            try {
                //Hibernate 5 annotation
                setFactory(new Configuration().configure().buildSessionFactory());
            } catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            System.out.println("Session Factory created!!!");
        }
        return dbAccess;
    }

    private static void setFactory(SessionFactory factory) {
        DBaccess.factory = factory;
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static boolean getIsEmpty(String table_name){
        Session session = factory.openSession();
        Transaction tx = null;
        Boolean result = false;

        try {
            tx = session.beginTransaction();
            result = session.createQuery("select 1 from "+table_name).setFetchSize(1).scroll(ScrollMode.FORWARD_ONLY).next();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
