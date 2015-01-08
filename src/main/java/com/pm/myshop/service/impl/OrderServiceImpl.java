/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.OrderDao;
import com.pm.myshop.domain.Order;
import com.pm.myshop.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kunda_000
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    
    
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> listAllOrders() {
        return orderDao.listAllOrders();
    }

    @Override
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }
    
}
