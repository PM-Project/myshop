/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.Orders;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kunda_000
 */

public interface OrderDao {
    public void saveOrder(Orders order);
    public Orders getOrderById(int id);
    public List<Orders> listAllOrders();
    public void deleteOrder(int id);
    
    public List<Orders> listAllOrdersByDate(Date fromDate, Date toDate);
}
