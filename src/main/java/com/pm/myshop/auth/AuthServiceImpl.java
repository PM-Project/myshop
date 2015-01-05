/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.auth;

import com.pm.myshop.dao.UserDao;
import com.pm.myshop.domain.UserLogin;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kunda_000
 */
@Service
public class AuthServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserLogin details = userDao.getUserByUsername(username);
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(details.getRole().toString()));
        authorities.add(new SimpleGrantedAuthority("ROLE_ANY"));

        details.setAuthorities(authorities);
        return details;
    }
}
