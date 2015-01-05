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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Santosh
 */
@Controller
@SessionAttributes({"product"})
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    VendorService vendorService;

    @Autowired
    HttpServletRequest request;

    @InitBinder
    public void InitDataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryPropertyEditor(categoryService));
    }

    @RequestMapping("/admin/product/list")
    public String productList(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "vendor/productList";
    }

    @RequestMapping("/vendor/product/form")
    public String productForm(@AuthenticationPrincipal UserLogin user, @ModelAttribute Product product, Model model) 
    {
        
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("categories", vendor.getCategories());
        model.addAttribute("product", product);
        return "vendor/productForm";
    }
    
    @RequestMapping("/vendor/product/edit/{productId}")
    public String productEditForm(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId, Product product, Model model) 
    {
        product = productService.getProductById(productId);
        if(product.getVendor().getId() != user.getVendor().getId())
            return "redirect:/403";
        
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("categories", vendor.getCategories());
        model.addAttribute("product", product);
        return "vendor/productForm";
    }
    

    @RequestMapping(value = "/vendor/product/save", method = RequestMethod.POST)
    public String productSave(@Valid @ModelAttribute Product product, @AuthenticationPrincipal UserLogin user, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "/vendor/productForm";
        } 
            
            if(product.getFile().getSize() > 0 && product.getFile().getContentType().equals("image/jpeg"))
            {
                String filename = UUID.randomUUID().toString();
                String path = request.getRealPath("/");

                MultipartFile file = product.getFile();
                File image = new File(path + "../../files/large/" + filename + ".jpg");
                File smallImage = new File(path + "../../files/thumb/" + filename + ".jpg");

                file.transferTo(image);
                
                try{
                    File oldfile = new File(path + "../../files/large/" + product.getFileName());
                    File oldthumb = new File(path + "../../files/thumb/" + product.getFileName());

                    if(oldfile.delete()) { System.out.println("File Successfully deleted"); }
                    oldthumb.delete();
                }catch(Exception e){
                    System.out.println("old file not deleted"+e.getMessage());
                }

                product.setFileName(filename + ".jpg");

                try {
                    BufferedImage bufimage = ImageIO.read(image);

                    BufferedImage bISmallImage = Scalr.resize(bufimage, 250); 
                    ImageIO.write(bISmallImage, "jpg", smallImage); 
                } catch (Exception e) {
                    System.out.println(e.getMessage()); 
                }
            }

            product.setVendor(user.getVendor());
            
            productService.saveProduct(product);
        
        return "redirect:/vendor/product";
    }

}
