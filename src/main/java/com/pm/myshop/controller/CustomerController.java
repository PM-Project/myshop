/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CustomerPropertyEditor;
import com.pm.myshop.propertyeditor.VendorPropertyEditor;
import com.pm.myshop.service.CustomerService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class CustomerController {
    
    @Autowired
    CustomerService customerservice;
    
       @InitBinder
    public void initConverter(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Vendor.class, new CustomerPropertyEditor(customerservice));        
    } 
    
    @RequestMapping("/customer/add")
    public String home1(Customer customer)
    {
        return "customer/form";
    }
    
    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer customer, BindingResult result)
    {
        if(result.hasErrors())
            return "customer/form";
        else
           customerservice.saveCustomer(customer);    
        return "redirect:/customer/list";
    }
    
    @RequestMapping(value = "/customer/list")
    public String listCustomers(Model model)
    {
        model.addAttribute("customers", customerservice.getAllCustomer());
        return "customer/list";
    }
    
    @RequestMapping("/customer/edit/{customerid}")
    public String editCustomer(@PathVariable("customerid") int id, Model model)
    {
        model.addAttribute("customer", customerservice.getCustomerById(id) );
        return "customer/form";
    }
    
    @RequestMapping("/customer/delete/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") int id, Model model)
    {
        customerservice.deleteCustomer(id);
        return "redirect:/customer/list";
    }
    
    
    
}
