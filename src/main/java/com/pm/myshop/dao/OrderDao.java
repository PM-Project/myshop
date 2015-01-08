/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.Order;
import java.util.List;

/**
 *
 * @author kunda_000
 */

public interface OrderDao {
    public void saveOrder(Order order);
    public Order getOrderById(int id);
    public List<Order> listAllOrders();
    public void deleteOrder(int id);
}
