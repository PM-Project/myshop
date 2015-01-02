/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service;

import com.pm.myshop.domain.Customer;
import java.util.List;

/**
 *
 * @author user
 */
public interface CustomerService {
    public void saveCustomer(Customer customer);
    public Customer getCustomerById(int id);
    public List<Customer> getAllCustomer();
    public void deleteCustomer(int id);
    
}
