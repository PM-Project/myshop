/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.propertyeditor;

import com.pm.myshop.domain.Category;
import com.pm.myshop.service.CategoryService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Santosh
 */
public class CategoryPropertyEditor extends PropertyEditorSupport
{
    private CategoryService categoryService;
    
    public CategoryPropertyEditor(CategoryService categoryService)
    {
        this.categoryService=categoryService;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        int id=Integer.parseInt(text);
        Category category=categoryService.getCategoryById(id);
        setValue(category);
    }
}
