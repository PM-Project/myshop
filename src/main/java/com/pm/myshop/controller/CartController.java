/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Cart;
import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.LineItem;
import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.CartService;
import com.pm.myshop.service.CustomerService;
import com.pm.myshop.service.ProductService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author kunda_000
 */
@Controller
@SessionAttributes({"cart"})
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    HttpServletRequest request;

    
    
    @ModelAttribute("cart")
    public Cart populateCart() throws FileNotFoundException, IOException {
        Cart cart = new Cart();
        cart.setTaxRate(7);
        return cart;
    }

    @RequestMapping("/cart")
    public String showCart(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model) {

        if (user != null && user.getCustomer() != null) {
            if (user.getCustomer().getPendingCart() != null && cart.getTotalItems()>0) {
                if (cart.getId() != user.getCustomer().getPendingCart().getId()) {
                    cart = cartService.combineCarts(user.getCustomer().getPendingCart(), cart);
                    cart.setCustomer(user.getCustomer());
                    user.getCustomer().setPendingCart(cart);
                    customerService.saveCustomer(user.getCustomer());
                    cartService.saveCart(cart);
                }else{ 
                    cart.setCustomer(user.getCustomer());
                    user.getCustomer().setPendingCart(cart);
                    customerService.saveCustomer(user.getCustomer());
                    cartService.saveCart(cart);
                }
            } else {
                cart.setCustomer(user.getCustomer());
                user.getCustomer().setPendingCart(cart);
                customerService.saveCustomer(user.getCustomer());
                cartService.saveCart(cart);
            }
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping("/cart/details")
    public String viewCart() {

        return "cartDetails";
    }

    @RequestMapping("/cart/ajax")
    public String viewCartAjax(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model) {

        model.addAttribute("cart", cart);
        return "cartAjax";
    }

    @RequestMapping("/cart/add/{productId}")
    public @ResponseBody
    String addItem(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId, @ModelAttribute("cart") Cart cart, Model model) {
        
        

        Product product = productService.getProductById(productId);
        LineItem item = new LineItem(product);
        cart.addLineItem(item);

        return "success";
    }
    
    
    @RequestMapping("/cart/add/{productId}/{quantity}")
    public @ResponseBody
    String addItemQty(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId, @PathVariable("quantity") int quantity, 
            @ModelAttribute("cart") Cart cart, Model model) {
        
        Product product = productService.getProductById(productId);
        LineItem item = new LineItem(product,quantity);
        cart.addLineItem(item);

        return "success";
    }
    
    
    

    @RequestMapping(value = "/cart/item/{productId}/{quantity}", method = RequestMethod.POST)
    public @ResponseBody
    String updateQuantityItem(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId,
            @PathVariable("quantity") int quantity,
            @ModelAttribute("cart") Cart cart, Model model) {
        
        cart.getLineItems().get(productId).setQuantity(quantity);
        cart.updateGrandTotal();
        
        
        
        return "success";
    }

    @RequestMapping(value = "/cart/remove/{productId}", method = RequestMethod.POST)
    public @ResponseBody
    String removeItem(
            @AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId,
            @ModelAttribute("cart") Cart cart, Model model) {

        cart.getLineItems().remove(productId);
        cart.updateGrandTotal();
        
        
        
        return "success";
    }

    @RequestMapping("/cart/clear")
    public String clearCart(@AuthenticationPrincipal UserLogin user, @ModelAttribute("cart") Cart cart, Model model) {
        
        if(user != null && user.getCustomer() != null && user.getCustomer().getPendingCart() != null)
        {
            cartService.deleteCart(user.getCustomer().getPendingCart().getId());
            
        }
        
        cart = new Cart();
        model.addAttribute("cart", cart);

        return "redirect:/cart/details";
    }

}
