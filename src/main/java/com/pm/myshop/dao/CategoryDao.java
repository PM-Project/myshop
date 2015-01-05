/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao;

import com.pm.myshop.domain.Category;
import java.util.List;

/**
 *
 * @author Santosh
 */
public interface CategoryDao 
{
    public void saveCategory(Category category);
    public void deleteCategory(int id);
    public List<Category> getAllCategory();
    public Category getCategoryById(int id);
    public Category getCategoryByCategoryName(String categoryName);
    public Category getCategoryByLink(String link);
}
