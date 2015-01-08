/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.OrderDao;
import com.pm.myshop.domain.Order;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kunda_000
 */
@Repository
public class OrderDaoImpl extends SessionUtil implements OrderDao {

    @Override
    public void saveOrder(Order order) {
        getSession().saveOrUpdate(order);
    }

    @Override
    public Order getOrderById(int id) {
        return (Order) getSession().get(Order.class, id);
    }

    @Override
    public List<Order> listAllOrders() {
        return getSession().createQuery("From Order").list();
    }

    @Override
    public void deleteOrder(int id) {
        Order order = getOrderById(id);
        if(order != null)
            getSession().delete(order);
    }
    
}
