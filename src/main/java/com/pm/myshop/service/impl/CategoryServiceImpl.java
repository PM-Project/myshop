/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.CategoryDao;
import com.pm.myshop.domain.Category;
import com.pm.myshop.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService
{   
    @Autowired
    CategoryDao categoryDao;
    
    
    @Override
    public void saveCategory(Category category) 
    {
        categoryDao.saveCategory(category);
    
    }

    @Override
    public Category getCategoryById(int id) 
    {
       return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() 
    {
        return categoryDao.getAllCategory();
    }

    @Override
    public void deleteCategory(int id) 
    {
        categoryDao.deleteCategory(id);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) 
    {
        return categoryDao.getCategoryByCategoryName(categoryName);
    }
    
}
