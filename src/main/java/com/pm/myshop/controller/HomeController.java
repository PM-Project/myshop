/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Vendor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kunda_000
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String home()
    {
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
    
}
