/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service;

import com.pm.myshop.domain.Category;
import java.util.List;

/**
 *
 * @author Santosh
 */
public interface CategoryService 
{
    public void saveCategory(Category category);
    public Category getCategoryById(int id);
    public List<Category> getAllCategories(); 
    public void deleteCategory(int id);
    public Category getCategoryByCategoryName(String categoryName);
    public Category getCateogryByLink(String link);
}
