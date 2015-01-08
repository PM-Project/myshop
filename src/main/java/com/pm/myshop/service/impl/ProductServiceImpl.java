/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.ProductDao;
import com.pm.myshop.domain.Product;
import com.pm.myshop.service.ProductService;
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
public class ProductServiceImpl implements ProductService 
{

    @Autowired
    ProductDao productDao;
    @Override
    public void saveProduct(Product product) 
    {
        productDao.saveProduct(product);
        productDao.indexProducts();
    }

    @Override
    public void deleteProduct(int id) 
    {
        productDao.deleteProduct(id);
    }

    @Override
    public List<Product> getAllProduct() 
    {
        return productDao.getAllProduct();
    }

    @Override
    public Product getProductById(int id) 
    {
        return productDao.getProductById(id);
    }

    @Override
    public Product getProductByProductName(String productName) 
    {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        return productDao.searchForProduct(searchText);
    }

    @Override
    public void indexProducts() {
        productDao.indexProducts();
    }
    
}
