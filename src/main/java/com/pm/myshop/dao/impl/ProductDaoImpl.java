/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.ProductDao;
import com.pm.myshop.domain.Product;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santosh
 */
@Repository
public class ProductDaoImpl extends SessionUtil implements ProductDao {

    @Override
    public void indexProducts() {
        try {

            FullTextSession fullTextSession = Search.getFullTextSession(getSession());
            fullTextSession.createIndexer().startAndWait();
            
        } catch (Exception e) {
            
        }
    }
    
    
    
    @Override
    public List<Product> searchForProduct(String searchText) 
    {
        
         FullTextSession fullTextSession = Search.getFullTextSession(getSession());
         QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
         org.apache.lucene.search.Query query = qb
                 .keyword().onFields("productName", "productDescription")
                 .matching(searchText)
                 .createQuery();

         org.hibernate.Query hibQuery =
                 fullTextSession.createFullTextQuery(query, Product.class);

         List<Product> results = hibQuery.list();
         return results;
      
    }
    
    

    @Override
    public void saveProduct(Product product) {
        getSession().saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            getSession().delete(product);
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return getSession().createQuery("SELECT p FROM Product p ORDER BY id DESC").list();
    }

    @Override
    public Product getProductById(int id) {
        return (Product) getSession().get(Product.class, id);

    }

    @Override
    public Product getProductByProductName(String productName) {
        return (Product) getSession().createQuery("Select c From Product Where ProductName='" + productName + "'").uniqueResult();
    }

    

}
