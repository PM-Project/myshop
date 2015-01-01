/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.UserDao;
import com.pm.myshop.domain.User;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kunda_000
 */

@Repository
public class UserDaoImpl extends SessionUtil implements UserDao {

    @Override
    public void saveUser(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if(user != null) getSession().delete(user);
    }

    @Override
    public List<User> listAllUsers() {
        return getSession().createQuery("FROM User").list();
    }

    @Override
    public User getUserById(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) getSession().createQuery("SELECT u FROM User u WHERE u.username = ?").setParameter(0, username).uniqueResult();
    }
    
}
