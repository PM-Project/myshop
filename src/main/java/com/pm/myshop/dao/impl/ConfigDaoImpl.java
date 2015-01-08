/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.ConfigDao;
import com.pm.myshop.domain.Config;
import com.pm.myshop.util.SessionUtil;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kunda_000
 */
@Repository
public class ConfigDaoImpl extends SessionUtil implements ConfigDao {

    @Override
    public Config getConfig() {
        return (Config) getSession().get(Config.class, 1);
    }
    
}
