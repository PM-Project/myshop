/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service;

import com.pm.myshop.domain.Product;
import java.util.List;

/**
 *
 * @author Santosh
 */
public interface ProductService 
{
    public void saveProduct(Product product);
    public void deleteProduct(int id);
    public List<Product> getAllProduct();
    public Product getProductById(int id);
    public Product getProductByProductName(String productName);
    public List<Product> searchProducts(String searchText);
    public void indexProducts();
}
