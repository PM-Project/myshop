/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.CategoryDao;
import com.pm.myshop.domain.Category;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santosh
 */
@Repository
public class CategoryDaoImpl extends SessionUtil implements CategoryDao {

    @Override
    public void saveCategory(Category category) {

        getSession().saveOrUpdate(category);

    }

    @Override
    public void deleteCategory(int id) {
        Category category = getCategoryById(id);
        if (category != null) {
            getSession().delete(category);
        }

    }

    @Override
    public List<Category> getAllCategory() {
        return getSession().createQuery("From Category").list();
    }

    @Override
    public Category getCategoryById(int id) {
        return (Category) getSession().get(Category.class, id);

    }


    @Override
    public Category getCategoryByLink(String link) {
        return (Category) getSession().createQuery("SELECT c FROM Category c WHERE c.link = ?").setFetchSize(1).setParameter(0, link).uniqueResult();
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
