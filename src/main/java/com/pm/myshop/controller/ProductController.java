/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Category;
import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.VendorService;
import com.pm.myshop.service.impl.VendorServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
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
public class ProductController 
{
    @Autowired 
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    VendorService vendorService;
    
    
    @InitBinder
    public void InitDataBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Category.class, new CategoryPropertyEditor(categoryService));
    }
    
    
    @RequestMapping("/vendor/product/list")
    public String productList(Model model)
    {
        model.addAttribute("products",productService.getAllProduct());
        return "product/productList";
    }
    
    @RequestMapping("/vendor/product/form")
    public String productForm(Product product, @AuthenticationPrincipal UserLogin user, Model model)
    {
        
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("categories",vendor.getCategories());

        return "vendor/productForm";
    }
    
    
    @RequestMapping(value="/vendor/product/save", method=RequestMethod.POST)
    public String categorySave(@Valid Product product, @AuthenticationPrincipal UserLogin user, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {    
            List<Category> categories= categoryService.getAllCategories();
            model.addAttribute("categories",categories);
            return "/vendor/productForm";
        }
            
        Vendor vendor= user.getVendor();
        product.setVendor(vendor);
        productService.saveProduct(product);

        return "redirect:/vendor/product/list";
    }
    
}
