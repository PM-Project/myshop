/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.OrderDao;
import com.pm.myshop.domain.Orders;
import com.pm.myshop.util.SessionUtil;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kunda_000
 */
@Repository
public class OrderDaoImpl extends SessionUtil implements OrderDao {

    @Override
    public void saveOrder(Orders order) {
        getSession().saveOrUpdate(order);
    }

    @Override
    public Orders getOrderById(int id) {
        return (Orders) getSession().get(Orders.class, id);
    }

    @Override
    public List<Orders> listAllOrders() {
        return getSession().createQuery("SELECT o From Orders o").list();
    }

    @Override
    public void deleteOrder(int id) {
        Orders order = getOrderById(id);
        if(order != null)
            getSession().delete(order);
    }

    @Override
    public List<Orders> listAllOrdersByDate(Date fromDate, Date toDate) {
        return getSession().createQuery("SELECT o FROM Orders o WHERE o.orderDate BETWEEN ? AND ?").setParameter(0, fromDate).setParameter(1, toDate).list();
    }
    
}
