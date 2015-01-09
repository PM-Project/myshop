/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.domain.Role;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.UserService;
import java.util.List;
import java.util.Map;
import com.pm.myshop.validator.PasswordValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author kunda_000
 */

@Controller
@SessionAttributes({"user"})
public class HomeController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    HttpServletRequest request;
    
    @Autowired
    HttpSession session;
    
    
    @RequestMapping("/")       
    public String index(Model model)
    {
        
        List<Product> products=productService.getAllProduct();
        model.addAttribute("products",products);
        return "index";
    }
    
    @RequestMapping("/menu")
    public String menus(Model model)
    {
        model.addAttribute("menus", categoryService.getAllCategories());
        return "menus";
    }
    
    
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal UserLogin user, Model model)
    {            
        if(user.getRole().equals(Role.ROLE_VENDOR))
            return "redirect:/vendor";
        else if(user.getRole().equals(Role.ROLE_ADMIN))
            return "redirect:/admin";        
        return "redirect:/";
    }
    
    
    @RequestMapping("/admin")
    public String admin()
    {
        return "admin/profile";
    }
    
    
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    
    @RequestMapping("/logout")
    public String logout()
    {
        
        return "login";
    }
    
    
    @RequestMapping("/403")
    public String errorPageAccessDenied()
    {
        return "403";
    }
    
    @RequestMapping("/404")
    public String errorPageNotFound()
    {
        return "404";
    }
    
    
    @RequestMapping("/info")
    public String actionInfo()
    {
        return "info";
    }    
    
    
    @RequestMapping("/verify/{code}")
    public String verifyUser(@PathVariable("code") String code, Model model, HttpSession session)
    {
        UserLogin user = userService.getUserByVerification(code);
        if(user != null)
        {
            user.setVerification("");
            model.addAttribute("user", user);
            return "user/password";
            
        }else{
            
            session.setAttribute("title", "User Verification Error");
            session.setAttribute("message", "User couldn't be verified with the given verification code.");
            
            return "info";
        }
    }
    
    
    
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("user") UserLogin user, Model model, BindingResult results, HttpSession session)
    {
        PasswordValidator passwordValidator = new PasswordValidator();
        
        passwordValidator.validate(user, results);
        
        if(results.hasErrors())
            return "user/password";
        
        user.setEnabled(true);
        userService.changePassword(user);
        
        session.setAttribute("title", "Change Password");
        session.setAttribute("message", "Password has been changed successfully. Plase use your new password to login");
        return "redirect:/login";
    }
    
    
    
}
