/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.CartDao;
import com.pm.myshop.domain.Cart;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santosh
 */
@Repository
public class CartDaoImpl extends SessionUtil implements CartDao
{

    @Override
    public void saveCart(Cart cart) 
    {
        getSession().saveOrUpdate(cart);
    }

    @Override
    public void deleteCart(int id) 
    {
        Cart cart=getCartById(id);
        
        getSession().delete(cart);
        
    }

    @Override
    public List<Cart> getAllCart() 
    {
        return getSession().createQuery("From Cart").list();
    }

    @Override
    public Cart getCartById(int id) 
    {
        return (Cart) getSession().get(Cart.class, id);
    }

    @Override
    public List<Cart> getCartByCustomerId(int customerId) 
    {
        return getSession().createQuery("SELECT c FROM Cart c WHERE c.customer.id=?").setParameter(0, customerId).list();
    }

    @Override
    public Cart mergeCart(Cart cart) {
        return (Cart) getSession().merge(cart);
    }
    
}
