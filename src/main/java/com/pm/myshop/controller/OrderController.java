/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Cart;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.LineItem;
import com.pm.myshop.domain.Orders;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.OrderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @Autowired
    CardController cardController;
    
    
    
    
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
            BindingResult result, Model model) throws IOException
    {
        if(result.hasErrors())
            return "checkoutGuest";
        
        Cart cart = (Cart) session.getAttribute("cart");
        
        
        if(!"success".equals(authenticateCard( customer.getAccount().getCardNumber(), cart.getGrandTotal(), customer.getAccount().getCardCvv())))
        {
            session.setAttribute("cardError", "Card Not Valid or Insufficient Fund");
            return "checkoutGuest";
        }
        
        
        
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
    public String checkoutConfirm(@AuthenticationPrincipal UserLogin user, 
            @ModelAttribute("cart") Cart cart, Model model) throws IOException
    {
        model.addAttribute("customer",user.getCustomer());
        if(user.getCustomer().getAccount() == null || user.getCustomer().getAccount().getCardNumber().equals(""))
        {
            session.setAttribute("message", "Please Provide correct account information to checkout.");
            return "redirect:/customer/profile";
        }
        
        if(!"success".equals(authenticateCard( user.getCustomer().getAccount().getCardNumber(), cart.getGrandTotal(), user.getCustomer().getAccount().getCardCvv())))
        {
            session.setAttribute("cardError", "Please Provide correct account information to checkout.");
            return "redirect:/customer/profile";
        }
        
        Orders order = new Orders();
        order.setCustomer(user.getCustomer());
        order.setCart(cart);
        order.setShipping(user.getCustomer().getAddress());
        
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
    
    
    @RequestMapping(value = "/order/confirm", method = RequestMethod.POST)
    public String orderConfirm(@ModelAttribute("order") Orders order, Model model) throws IOException
    {
        order.getCustomer().setPendingCart(null);
        orderService.saveOrder(order);
        
        double amount = order.getCart().getGrandTotal();
        String deductFrom = order.getCustomer().getAccount().getCardNumber();
        String depositeTo = "4564546545646567";
        
        String output = financeDivide("Sales", amount, deductFrom, depositeTo);
        
        try{
            if("success".equals(output))
            {
                for(LineItem item : order.getCart().getLineItems().values())
                {
                    double amountShare = item.getAmount() * 0.75;
                    deductFrom = "4564546545646567";
                    depositeTo = item.getProduct().getVendor().getAccount().getCardNumber();
                    financeDivide("Sales", amountShare, deductFrom, depositeTo);
                }

            }
        }catch(Exception e){}
        
        session.setAttribute("title", "Order Submited Successfully");
        session.setAttribute("message", "Your Order has been submited successfully");
        
        model.addAttribute("cart", new Cart());
        model.addAttribute("order",new Orders());
        
        return "redirect:/info";
    }
    
    
    
    
    
    public String financeDivide(
            String particular, 
            double amount,
            String deductFrom,
            String depositeTo
    ) throws IOException {
        
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet("http://localhost:8080/Team4_MyFinance/add?particular="+particular+"&amount="+amount+"&deductFrom="+deductFrom+"&depositeTo="+depositeTo);
            
        getRequest.addHeader(BasicScheme.authenticate(
                new UsernamePasswordCredentials("admin", "admin"),"UTF-8", false));

            HttpResponse response = httpClient.execute(getRequest);
            
            if (response.getStatusLine().getStatusCode() != 200) {
                
                return "fail";
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

            while ((output = br.readLine()) != null) {
                return output;
            }

            httpClient.getConnectionManager().shutdown();

            return "fail";
    }
    
    
    
    
    
    
    
    public String authenticateCard( String cardNo,  double balance,  String cvv) throws IOException {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        
        String encCard = encryptCardNumber(cardNo);
        
        HttpGet getRequest = new HttpGet("http://localhost:8080/Team4_CardValidator/validate?cardNo="+encCard+"&balance="+balance+"&cvv="+cvv);
            
        getRequest.addHeader(BasicScheme.authenticate(
                new UsernamePasswordCredentials("admin", "admin"),"UTF-8", false));

        
            HttpResponse response = httpClient.execute(getRequest);
            
            if (response.getStatusLine().getStatusCode() != 200) {
                session.setAttribute("cardvalidation", "fail");
                return "fail";
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

            while ((output = br.readLine()) != null) {
                session.setAttribute("cardvalidation", output);
                return output;
            }

            httpClient.getConnectionManager().shutdown();

            session.setAttribute("cardvalidation", "fail");
            return "fail";
    }

    

    public String encryptCardNumber(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
}
