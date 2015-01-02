/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.auth;

import com.pm.myshop.dao.UserDao;
import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.Status;
import com.pm.myshop.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author kunda_000
 */
public class UserAuthenticator implements AuthenticationProvider
{

    private UserDao userDao;

    public UserAuthenticator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        User user = userDao.getUserByUsername(a.getName());
        if (user == null) {
            return null;
        }
        
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        if(user.getStatus().equals(Status.Active))
        {
            if (encoder.matches(a.getCredentials().toString(),user.getPassword())) 
            {
                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

                grantedAuths.add(new SimpleGrantedAuthority(user.getRole().getName()));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_ANY"));

                Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), grantedAuths);

                return auth;
            }
        }
        return null;
    }

    

    @Override
    public boolean supports(Class<?> type)
    {

        return type.equals(UsernamePasswordAuthenticationToken.class);
    
    }
}