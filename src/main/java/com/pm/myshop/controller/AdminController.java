/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.MailService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.UserService;
import com.pm.myshop.service.VendorService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    MailService mailService;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    HttpSession session;
    
    
    @RequestMapping("/admin/vendor/list")
    public String vendorList(Model model)
    {
        model.addAttribute("vendors", vendorService.getAllVendors());
        
        return "admin/vendorList";
    }
    
    
    @RequestMapping("/admin/vendor/approve/{vendorId}")
    public String vendorApprove(@PathVariable("vendorId") int vendorid, Model model)
    {
        Vendor vendor = vendorService.getVendorById(vendorid);
        String code = vendor.getUser().getVerification();
        
        if(!"".equals(code))
            mailService.sendMail(vendor.getEmail(), "Account Activated", "<h2>Vendor Registration</h2><p>Thank you for registration. Please click on below link to verify your email and create account password.</p><p><a href='http://localhost/myshop/verify/"+code+"'>Click Here</a></p>");
        
        session.setAttribute("message", "Vendor Approved Successfully");
        return "redirect:/admin/vendor/list";
    }
    
    
    @RequestMapping("/admin/vendor/enable/{vendorId}")
    public String vendorEnable(@PathVariable("vendorId") int vendorid, Model model)
    {
        Vendor vendor = vendorService.getVendorById(vendorid);
        vendor.getUser().setEnabled(true);
        vendorService.saveVendor(vendor);
        
        session.setAttribute("message", "Vendor Enabled Successfully");
        
        return "redirect:/admin/vendor/list";
    }
    
    @RequestMapping("/admin/customer/list")
    public String customerList(Model model)
    {
        model.addAttribute("customers", customerService.getAllCustomer());
        
        return "admin/customerList";
    }
    
    
    @RequestMapping("/new/admin")
    public String createNewAdmin()
    {
        UserLogin user = new UserLogin();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRole(Role.ROLE_ADMIN);
        
        userService.changePassword(user);
        
        return "redirect:/admin";
    }
    
    
}
