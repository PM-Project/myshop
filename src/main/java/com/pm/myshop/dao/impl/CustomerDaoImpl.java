/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.CustomerDao;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class CustomerDaoImpl extends SessionUtil  implements CustomerDao {

    @Override
    public void saveCustomer(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
      return (Customer) getSession().get(Customer.class, id);  
    }

    @Override
    public List<Customer> getAllCustomer() {
      return getSession().createQuery("From Customer").list();  
    
    }

    @Override
    public void deleteCustomer(int id) {
      Customer customer=getCustomerById(id);
        if(customer!=null)
        getSession().delete(customer);  
    }
    
    
}
