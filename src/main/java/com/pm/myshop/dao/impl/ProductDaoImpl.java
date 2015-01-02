/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.ProductDao;
import com.pm.myshop.domain.Product;
import com.pm.myshop.util.SessionUtil;
import java.awt.BorderLayout;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santosh
 */
@Repository
public class ProductDaoImpl extends SessionUtil implements ProductDao
{

    @Override
    public void saveProduct(Product product) 
    {
        System.out.println("###########" + product.getCategory().toString());
        getSession().saveOrUpdate(product);
    
    }

    @Override
    public void deleteProduct(int id) 
    {
        Product product=getProductById(id);
        if(product!=null)
            getSession().delete(product);
    }

    @Override
    public List<Product> getAllProduct()
    {
        return getSession().createQuery("From Product").list();
    }

    @Override
    public Product getProductById(int id)
    {
        return (Product) getSession().get(Product.class, id);
        
    }

    @Override
    public Product getProductByProductName(String productName) 
    {
        return (Product) getSession().createQuery("Select c From Product Where ProductName='" + productName + "'").uniqueResult();
    }
    
}
