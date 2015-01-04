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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
    
    @RequestMapping("/photo")
    public String productPhoto(Product product,Model model)
    {
        model.addAttribute("products",productService.getAllProduct());
        return "product/productPhoto";
    }
    
    @RequestMapping("/form")
    public String productForm(Product product, Model model)
    {
        String addUpdateMessage="";
        List<Category> categories= categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        //System.out.println("#########################################" + categories.size());
        if (product.getId()==0)
           addUpdateMessage="Add Product";
        else
           addUpdateMessage="Update Product";
        model.addAttribute("addUpdateMessage", addUpdateMessage);
                
        return "product/productForm";
    }
    
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String categorySave(@Valid Product product, BindingResult result, Model model,
            HttpServletRequest request) throws IOException
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
            String filename  = UUID.randomUUID().toString();
            String path = request.getRealPath("/");
            
            MultipartFile file=product.getFile();
            file.transferTo(new File(path+"../../../files/"+filename+".jpg"));
            product.setFileName(filename+".jpg");
            
            
        Vendor vendor= venderService.getVendorById(2);
        product.setVendor(vendor);
            //System.out.println("Product is "+product.getCategory().toString());
            productService.saveProduct(product);
        }
        //just for testing purpose-----------
       
        //------------------------------------
        return "redirect:/product/list";
    }
    
}
