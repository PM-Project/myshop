/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.CustomerDao;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao customerDao;

    @Override
    public void saveCustomer(Customer customer) {
       customerDao.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
           return customerDao.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerDao.getAllCustomer();
    }

    @Override
    public void deleteCustomer(int id) {

    customerDao.deleteCustomer(id);
    }
    
}
