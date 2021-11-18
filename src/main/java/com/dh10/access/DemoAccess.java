package com.dh10.access;

import com.dh10.access.model.beans.User;
import com.dh10.access.model.dao.Dao;
import com.dh10.access.model.dao.UserDao;
import com.dh10.utils.DBaccess;

public class DemoAccess {

    public static void main(String[] args) {
       DBaccess dbAccess = DBaccess.getInstance();

       User user = new User("ADMIN","Big","Snopy","Italy","qwerty");

        Dao<User> userDao = new UserDao();

        userDao.save(user);
    }
}
