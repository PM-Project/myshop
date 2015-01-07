/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.daoReportImpl;

import com.pm.myshop.daoReport.CustomerReportDao;
import com.pm.myshop.domain.Test;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sunil
 */
@Repository
public class CustomerReportDaoImpl extends SessionUtil implements CustomerReportDao{

    @Override
    public List<Test> getAllCustomer() {
        List<Test> tests=getSession().createCriteria(Test.class).add(Restrictions.eq("salary", "22")).list();
        return tests;
    }
    
}
