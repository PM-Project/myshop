/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.MailService;
import com.pm.myshop.service.UserService;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author user
 */
@Controller
@SessionAttributes({"customer"})
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    MailService mailService;
    
    
    @RequestMapping("/register")
    public String register(Customer customer)
    {
        
        return "customer/customerForm";
    }
    
    @RequestMapping(value = "/customer")
    public String vendorProfile(@AuthenticationPrincipal UserLogin user, Model model)
    {
        model.addAttribute("user",user);
        return "customer/profile";
    }
    
    
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session)
    {
        
        if(result.hasErrors())
            return "customer/customerForm";
        
        if(userService.getUserByUsername(customer.getEmail()) != null)
        {
            session.setAttribute("message", "User Email already exists please chooose another one.");
            return "customer/customerForm";
        }  
        String code = UUID.randomUUID().toString().toUpperCase();
        
        UserLogin user = new UserLogin();
        user.setVerification(code);
        user.setUsername(customer.getEmail());
        user.setRole(Role.ROLE_CUSTOMER);
        customer.setUser(user);
        
        mailService.sendMail(customer.getEmail(), "Account Created", "<h2>Customer Registration</h2><p>Thank you for registration. Please click on below link to verify your email and create account password.</p><p><a href='http://localhost:8080/myshop/verify/"+code+"'>Click Here</a></p>");

        customerService.saveCustomer(customer);
        
        session.setAttribute("title", "Registration Successfull");
        session.setAttribute("message", "Thank you for registration. Please check your email and proceed with given information");
        
        return "redirect:/info";
        
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer customer, BindingResult result)
    {
        if(result.hasErrors())
            return "customer/customerForm";
        else
           customerService.saveCustomer(customer);    
        return "redirect:/customer/list";
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/customer/list")
    public String listCustomers(Model model)
    {
        model.addAttribute("customers", customerService.getAllCustomer());
        return "customer/customerList";
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping("/customer/edit/{customerid}")
    public String editCustomer(@PathVariable("customerid") int id, Model model)
    {
        model.addAttribute("customer", customerService.getCustomerById(id) );
        return "customer/customerForm";
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping("/customer/delete/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") int id, Model model)
    {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
    
    
    @RequestMapping("/customer/profile")
    public String customerAccount(@AuthenticationPrincipal UserLogin user, Model model)
    {
        model.addAttribute("customer", user.getCustomer());
        
        return "customer/editProfile";
    }
    
    @RequestMapping(value = "/customer/profile", method = RequestMethod.POST)
    public String updateAccount(@AuthenticationPrincipal UserLogin user,@ModelAttribute("customer") Customer customer, Model model)
    {
        customerService.saveCustomer(customer);
        
        return "redirect:/customer";
    }
    
}
