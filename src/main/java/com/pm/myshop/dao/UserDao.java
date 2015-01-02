/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.User;
import java.util.List;

/**
 *
 * @author kunda_000
 */
public interface UserDao {
    public void saveUser(User user);
    public void deleteUser(int id);
    public List<User> listAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public User getUserByVerification(String code);
}
