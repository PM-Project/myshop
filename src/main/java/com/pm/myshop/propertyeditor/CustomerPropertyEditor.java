/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.propertyeditor;

import com.pm.myshop.domain.Customer;
import com.pm.myshop.service.CustomerService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author user
 */
public class CustomerPropertyEditor extends PropertyEditorSupport {
    
      private CustomerService customerService;

    public CustomerPropertyEditor(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        int id = Integer.parseInt(text);
        Customer customer = customerService.getCustomerById(id);
        setValue(customer);
    }
    
    
}
