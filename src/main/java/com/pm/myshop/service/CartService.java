/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service;

import com.pm.myshop.domain.Cart;
import java.util.List;

/**
 *
 * @author Santosh
 */
public interface CartService 
{
    public void saveCart(Cart cart);
    public void deleteCart(int id);
    public List<Cart> getAllCart();
    public Cart getCartById(int id);
    public List<Cart> getCartByCustomerId(int customerId);
    public Cart mergeCart(Cart cart);
    public Cart combineCarts(Cart a, Cart b);
}
