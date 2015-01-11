/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.OrderDao;
import com.pm.myshop.domain.LineItem;
import com.pm.myshop.domain.Orders;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.OrderService;
import java.util.ArrayList;
import java.util.Date;
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
    public void saveOrder(Orders order) {
        orderDao.saveOrder(order);
    }

    @Override
    public Orders getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Orders> listAllOrders() {
        return orderDao.listAllOrders();
    }

    @Override
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public List<LineItem> getSalesByVendor(Vendor vendor) 
    {
        
        List<LineItem> orderItems = new ArrayList<>();
        List<Orders> allOrder = listAllOrders();
        for(Orders order : allOrder)
        {
                for(LineItem item : order.getCart().getLineItems().values())
                {
                        if(item.getProduct().getVendor().equals(vendor))
                            orderItems.add(item);
                }
        }
        return orderItems;
    }

    @Override
    public List<LineItem> getSalesByVendorAndByDate(Vendor vendor, Date fromDate, Date toDate) {
        List<LineItem> items = new ArrayList<>();
        List<Orders> orders = orderDao.listAllOrdersByDate(fromDate, toDate);
        for(Orders order : orders)
        {
                for(LineItem item : order.getCart().getLineItems().values())
                {
                        if(item.getProduct().getVendor().equals(vendor))
                            items.add(item);
                }
        }
        return items;
    }

    
    
}
