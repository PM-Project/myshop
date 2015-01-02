/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Category;
import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.VendorService;
import com.pm.myshop.service.impl.VendorServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Santosh
 */
@Controller
@RequestMapping("/product")
public class ProductController 
{
    @Autowired 
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    VendorService venderService;
    
    
    @InitBinder
    public void InitDataBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Category.class, new CategoryPropertyEditor(categoryService));
    }
    
    
    @RequestMapping("/list")
    public String productList(Model model)
    {
        model.addAttribute("products",productService.getAllProduct());
        return "product/productList";
    }
    
    @RequestMapping("/form")
    public String productForm(Product product, Model model)
    {
        List<Category> categories= categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        //System.out.println("#########################################" + categories.size());
        return "product/productForm";
    }
    
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String categorySave(@Valid Product product, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {    
            List<Category> categories= categoryService.getAllCategories();
            model.addAttribute("categories",categories);
            return "/product/productForm";
            //return "redirect:/product/form";
        }
         else
        {
            
        Vendor vendor= venderService.getVendorById(1);
        product.setVendor(vendor);
            //System.out.println("Product is "+product.getCategory().toString());
            productService.saveProduct(product);
        }
        //just for testing purpose-----------
       
        //------------------------------------
        return "redirect:/product/list";
    }
    
}
