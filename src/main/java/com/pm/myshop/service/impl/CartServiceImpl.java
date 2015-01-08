/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.CartDao;
import com.pm.myshop.domain.Cart;
import com.pm.myshop.domain.LineItem;
import com.pm.myshop.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Santosh
 */

@Service
@Transactional
public class CartServiceImpl implements CartService 
{
    
    @Autowired
    CartDao cartDao;

    @Override
    public void saveCart(Cart cart) {
        cartDao.saveCart(cart);
    }

    @Override
    public void deleteCart(int id) {
        cartDao.deleteCart(id);
    }

    @Override
    public List<Cart> getAllCart() {
        return cartDao.getAllCart();
    }

    @Override
    public Cart getCartById(int id) {
        return cartDao.getCartById(id);
    }

    @Override
    public List<Cart> getCartByCustomerId(int customerId) {
        return cartDao.getCartByCustomerId(customerId);
    }

    @Override
    public Cart mergeCart(Cart cart) {
        return cartDao.mergeCart(cart);
    }
    
    @Override
    public Cart combineCarts(Cart a, Cart b)
    {
        
        for(LineItem item : b.getLineItems().values())
        {
            a.addLineItem(item);
        }
        return a;
    }
    
    
    
    
    
}
