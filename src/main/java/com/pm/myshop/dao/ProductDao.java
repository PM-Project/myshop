/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.Product;
import java.util.List;

/**
 *
 * @author Santosh
 */
public interface ProductDao 
{
    public void saveProduct(Product product);
    public void deleteProduct(int id);
    public List<Product> getAllProduct();
    public Product getProductById(int id);
    public Product getProductByProductName(String productName);
    public void indexProducts();
    public List<Product> searchForProduct(String searchText);
}
