/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Cart;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.Orders;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.reportService.CustomerReportSerivce;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.OrderService;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
@SessionAttributes({"cart","order"})
public class OrderController {
    
    
    @Autowired
    OrderService orderService;
    
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    HttpSession session;
    
    @Autowired
    HttpServletRequest request;
    
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
    public String checkoutGuestPost( 
            @Valid @ModelAttribute("customer") Customer customer, 
            BindingResult result, Model model)
    {
        if(result.hasErrors())
            return "checkoutGuest";
        
        if(!request.getSession(true).getAttribute("cardvalidation").equals("success"))
        {
            session.setAttribute("cardError", "Card Not Valid or Insufficient Fund");
            return "checkoutGuest";
        }
        
        
        Cart cart = (Cart) session.getAttribute("cart");
        
        Orders order = new Orders();
        order.setCustomer(customer);
        order.setCart(cart);
        order.setShipping(customer.getAddress());
        
        Date date = new Date();
        order.setOrderDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 7);
        date = cal.getTime();
        
        
        order.setShippingDate(date);
//        orderService.saveOrder(order);
        
        model.addAttribute("order",order);
        
        return "order";
    }
    
    
    @Secured("ROLE_CUSTOMER")
    @RequestMapping("/checkout/confirm")
    public String checkoutConfirm(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model)
    {
        
        if(user.getCustomer().getAccount() == null)
            return "redirect:/customer/profile";
        
        
        
        return "checkoutCustomer";
    }
    
    
    @RequestMapping(value = "/order/confirm", method = RequestMethod.POST)
    public String orderConfirm(@ModelAttribute("order") Orders order, Model model)
    {
        
        orderService.saveOrder(order);
        
        session.setAttribute("title", "Order Submited Successfully");
        session.setAttribute("message", "Your Order has been submited successfully");
        
        model.addAttribute("cart", new Cart());
        model.addAttribute("order",new Orders());
        
        return "redirect:/info";
    }
    
    
    
    
    
}
