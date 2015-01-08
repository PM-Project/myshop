/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Category;
import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.MailService;
import com.pm.myshop.service.VendorService;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Jagendra
 */
@Controller
@EnableAsync
@SessionAttributes({"vendor"})
public class VendorController {
    
    
    @Autowired
    VendorService vendorService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    MailService mailService;
    
    @Autowired
    HttpSession session;
    
    @InitBinder
    public void initConverter(WebDataBinder binder)
    {
        binder.registerCustomEditor(Category.class, new CategoryPropertyEditor(categoryService)); 
    } 
    
    @RequestMapping("/register/vendor")
    public String vendorRegister(Vendor vendor)
    {
        return "vendor/vendorForm";
    }
    
    @RequestMapping(value = "/vendor")
    public String vendorProfile(@AuthenticationPrincipal UserLogin user, Model model)
    {
        model.addAttribute("user", user);
        return "vendor/profile";
    }
    
    @RequestMapping(value = "/vendor/categories")
    public String vendorCategories(@AuthenticationPrincipal UserLogin user, Model model)
    {
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("vendor", vendor);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "vendor/categories";
    }
    
    
    @RequestMapping(value = "/vendor/categories", method = RequestMethod.POST)
    public String vendorUpdateCategories(@ModelAttribute Vendor vendor, @AuthenticationPrincipal UserLogin user, BindingResult result, Model model)
    {
        model.addAttribute("vendor", vendor);
        model.addAttribute("categories", categoryService.getAllCategories());
        
        if(result.hasErrors())
            return "vendor/categories";
        
        vendorService.saveVendor(vendor);
        session.setAttribute("message", "Category Added to your List Successfully");
        return "redirect:/vendor/categories";
    }
    
    @RequestMapping(value = "/vendor/product")
    public String vendorProducts(@AuthenticationPrincipal UserLogin user, Model model)
    {
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("products", vendor.getProducts());
        return "vendor/productList";
    }
    
    
    
    @RequestMapping(value = "/register/vendor", method = RequestMethod.POST)
    public String saveUser(Vendor vendor, UserLogin user, BindingResult result, HttpSession session)
    {
        if(result.hasErrors())
            return "vendor/vendorForm";
        
        String code = UUID.randomUUID().toString().toUpperCase();
        user.setVerification(code);
        user.setUsername(vendor.getEmail());
        user.setRole(Role.ROLE_VENDOR);
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
    
    
    
    @RequestMapping("/vendor/category/form")
    public String categoryForm(Category category)
    {
        
       // Category category=new Category();
       // model.addAttribute("category", category);
        return "/vendor/categoryForm";
    }
    
    
    @RequestMapping(value="/vendor/category/save", method=RequestMethod.POST)
    public String categorySave(@ModelAttribute Category category, BindingResult result)
    {
        if(result.hasErrors())
            return "/vendor/categoryForm";

        category.setLink(category.getCategoryName().toLowerCase().replace(" ", "-"));
        
        categoryService.saveCategory(category);
        
        return "redirect:/vendor/categories";
    }
    
    
    
}
