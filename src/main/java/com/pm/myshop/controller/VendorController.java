/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.Status;
import com.pm.myshop.domain.User;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.VendorPropertyEditor;
import com.pm.myshop.service.MailService;
import com.pm.myshop.service.VendorService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Jagendra
 */
@Controller
public class VendorController {
    
    
    @Autowired
    VendorService vendorService;
    
    @Autowired
    MailService mailService;
    
    @InitBinder
    public void initConverter(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));        
    } 
    
    @RequestMapping("/register/vendor")
    public String vendorRegister(Vendor vendor)
    {
        return "vendor/vendorForm";
    }
    
    @RequestMapping(value = "/register/vendor", method = RequestMethod.POST)
    public String saveUser(Vendor vendor, User user, BindingResult result, HttpSession session)
    {
        if(result.hasErrors())
            return "vendor/vendorForm";
        
        String code = UUID.randomUUID().toString().toUpperCase();
        user.setVerification(code);
        user.setUsername(vendor.getEmail());
        user.setRole(new Role("ROLE_VENDOR"));
        vendor.setUrl(vendor.getBrand().toLowerCase().replace(" ", "-"));
        vendor.setUser(user);
        
        
        mailService.sendMail(vendor.getEmail(), "Account Created", "<h2>Vendor Registration</h2><p>Thank you for registration. Please click on below link to verify your email and create account password.</p><p><a href='http://localhost/myshop/verify?code="+code+"'>Click Here</a></p>");

        vendorService.saveVendor(vendor);
        
        session.setAttribute("title", "Registration Successfull");
        session.setAttribute("message", "Thank you for registration. Please check your email and proceed with given information");
        
        return "redirect:/info";
    }
    
    
    @RequestMapping(value = "/vendor/list")
    public String listUsers(Model model)
    {
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "vendor/vendorList";
    }
    
    @RequestMapping("/vendor/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") int id, Model model)
    {
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "vendor/form";
    }
    
    @RequestMapping("/vendor/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") int id, Model model)
    {
        vendorService.deleteVendor(id);
        return "redirect:/vendor/list";
    }
    
}
