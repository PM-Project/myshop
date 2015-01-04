/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.User;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kunda_000
 */
@Controller
public class HomeController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    ProductService productService;
    
    @RequestMapping("/")
    public String home(Model model)
    {
        List<Product> products=productService.getAllProduct();
        model.addAttribute("products",products);
        return "index";
    }
    
    
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    
    @RequestMapping("/register")
    public String register()
    {
        return "customer/customerForm";
    }
    
    @RequestMapping("/info")
    public String actionInfo()
    {
        return "info";
    }
    
    
    
    @RequestMapping("/verify")
    public String verifyUser(@RequestParam("code") String code, HttpSession session)
    {
        User user = userService.getUserByVerification(code);
        if(user != null)
            return "user/password";
        else
        {
            session.setAttribute("title", "User Verification Error");
            session.setAttribute("message", "User couldn't be verified with the given verification code.");
            session.setAttribute("userToUpdate", user);
            return "info";
        }
    }
    
    
    
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String changePassword(@RequestParam Map<String,String> map, HttpSession session)
    {
        User user = (User) session.getAttribute("userToUpdate");
        
        return "info";
    }
    
    
    
}
