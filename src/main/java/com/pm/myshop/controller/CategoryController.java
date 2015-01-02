/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Category;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Santosh
 */
@Controller
@RequestMapping("/category")
public class CategoryController 
{
    
    @Autowired
    CategoryService categoryService;
    
    
    
    
    @RequestMapping("/list")
    public String categoryList(Model model)
    {
        List<Category> categories=categoryService.getAllCategories();
        //System.out.print("##############################################" + categories.size());
        model.addAttribute("categories",categories);
        return "category/categoryList";
    }
    
    @RequestMapping("/form")
    public String categoryForm(Category category)
    {
       // Category category=new Category();
       // model.addAttribute("category", category);
        return "/category/categoryForm";
    }
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String categorySave(@Valid Category category, BindingResult result)
    {
        if(result.hasErrors())
            return "/category/categoryForm";
        else
            categoryService.saveCategory(category);
        return "redirect:/category/list";
    }
    
    @RequestMapping("/edit/{categoryId}")
    public String categoryEdit(@PathVariable("categoryId") int id,Model model)
    {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "/category/categoryForm";
    }
    
    @RequestMapping("/delete/{categoryId}")
    public String categoryDelete(@PathVariable("categoryId") int id,Model model)
    {
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }
}
