/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.UserLogin;
import java.util.List;

/**
 *
 * @author kunda_000
 */
public interface UserDao {
    public void saveUser(UserLogin user);
    public void deleteUser(int id);
    public List<UserLogin> listAllUsers();
    public UserLogin getUserById(int id);
    public UserLogin getUserByUsername(String username);
    public UserLogin getUserByVerification(String code);
}
