/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kunda_000
 */
@Controller
public class AdminController {
    
    @Autowired
    VendorService vendorService;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    
    @RequestMapping("/admin/vendor/list")
    public String vendorList(Model model)
    {
        model.addAttribute("vendors", vendorService.getAllVendors());
        
        return "admin/vendorList";
    }
    
    
    @RequestMapping("/admin/customer/list")
    public String customerList(Model model)
    {
        model.addAttribute("customers", customerService.getAllCustomer());
        
        return "admin/customerList";
    }
    
    
}
