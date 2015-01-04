/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.UserDao;
import com.pm.myshop.domain.UserLogin;
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
    public void saveUser(UserLogin user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        UserLogin user = getUserById(id);
        if(user != null) getSession().delete(user);
    }

    @Override
    public List<UserLogin> listAllUsers() {
        return getSession().createQuery("FROM UserLogin").list();
    }

    @Override
    public UserLogin getUserById(int id) {
        return (UserLogin) getSession().get(UserLogin.class, id);
    }

    @Override
    public UserLogin getUserByUsername(String username) {
        return (UserLogin) getSession().createQuery("SELECT u FROM UserLogin u WHERE u.username = ?").setParameter(0, username).uniqueResult();
    }

    @Override
    public UserLogin getUserByVerification(String code) {
        return (UserLogin) getSession().createQuery("SELECT u FROM UserLogin u WHERE u.verification = ?").setParameter(0, code).uniqueResult();
    }
    
}
