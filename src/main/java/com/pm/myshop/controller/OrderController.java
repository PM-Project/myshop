/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Cart;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.OrderService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author kunda_000
 */
@Controller
@SessionAttributes({"cart"})
public class OrderController {
    
    
    @Autowired
    OrderService orderService;
    
    
    
    @RequestMapping("/checkout")
    public String checkout(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model, HttpSession session)
    {
        if(cart.getTotalItems() < 1)
            return "redirect:/cart/details";
        
        if(user == null)
            return "preCheckOut";
        
        if(user != null && user.getCustomer() == null)
        {
            session.setAttribute("message", "You are not logged in with customer account. Please logout and relogin with customer account.");
            return "info";
        }
        
        return "redirect:/checkout/confirm";
    }
    
    
    @RequestMapping(value = "/checkout/guest", method = RequestMethod.GET)
    public String checkoutGuest(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model)
    {
        if(user != null && user.getCustomer() != null)
            return "redirect:/checkout/confirm";
        if(cart.getLineItems().isEmpty())
            return "redirect:/cart/details";
        
        model.addAttribute("customer", new Customer());
        
        return "checkoutGuest";
    }
    
    @RequestMapping(value = "/checkout/guest", method = RequestMethod.POST)
    public String checkoutGuestPost(@AuthenticationPrincipal UserLogin user, 
            @Valid @ModelAttribute("customer") Customer customer, @ModelAttribute("cart") Cart cart, 
            BindingResult result, Model model)
    {
        if(user != null && user.getCustomer() != null)
            return "redirect:/checkout/confirm";
        if(cart.getLineItems().isEmpty())
            return "redirect:/cart/details";
        
        if(result.hasErrors())
            return "checkoutGuest";
        
        return "checkoutGuest";
    }
    
    
    @Secured("ROLE_CUSTOMER")
    @RequestMapping("/checkout/confirm")
    public String checkoutConfirm(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model)
    {
        
        if(user.getCustomer().getAccount() == null)
            return "redirect:/customer/profile";
        
        
        
        return "checkoutCustomer";
    }
    
}
