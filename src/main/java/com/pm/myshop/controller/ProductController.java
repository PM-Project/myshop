/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;


import com.pm.myshop.domain.Category;
import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.Unit;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.VendorService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @Autowired
    HttpSession session;

    @InitBinder
    public void InitDataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryPropertyEditor(categoryService));
    }
    
    
    @RequestMapping(value = "/search/products", method = RequestMethod.POST)
    public String productList(@RequestParam("query") String query, Model model) {
        
        model.addAttribute("products", productService.searchProducts(query));
        
        return "productSearch";
    }
    
    

    @RequestMapping("/admin/product/list")
    public String productList(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "vendor/productList";
    }

    @RequestMapping("/vendor/product/form")
    public String productForm(@AuthenticationPrincipal UserLogin user, Model model) 
    {
        
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("categories", vendor.getCategories());
        model.addAttribute("units", Unit.values());
        model.addAttribute("product", new Product());
        return "vendor/productForm";
    }
    
    @RequestMapping("/vendor/product/edit/{productId}")
    public String productEditForm(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId, Model model) 
    {
        Product product = productService.getProductById(productId);
        if(product.getVendor().getId() != user.getVendor().getId())
            return "redirect:/403";
        
        Vendor vendor = vendorService.mergeVendor(user.getVendor());
        model.addAttribute("categories", vendor.getCategories());
        model.addAttribute("product", product);
        model.addAttribute("units", Unit.values());
        return "vendor/productForm";
    }
    
    
    @RequestMapping("/vendor/product/delete/{productId}")
    public String productDeleteForm(@AuthenticationPrincipal UserLogin user,
            @PathVariable("productId") int productId, Model model) 
    {
        Product product = productService.getProductById(productId);
        if(product.getVendor().getId() != user.getVendor().getId())
            return "redirect:/403";
        
        productService.deleteProduct(productId);
        
        return "redirect:/vendor/product";
    }
    
    

    @RequestMapping(value = "/vendor/product/save", method = RequestMethod.POST)
    public String productSave(@Valid @ModelAttribute Product product, @AuthenticationPrincipal UserLogin user, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "/vendor/productForm";
        } 
            String message = "";
            
            if(product.getFile().getSize() > 0)
            {
                if( product.getFile().getContentType().equals("image/jpeg"))
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
                }else{
                    message = "Picture Error. Please choose JPEG file.<br/>";
                }
            }
            
            message += "Product Information Updated Successfully";

            session.setAttribute("message", message);
            
            product.setVendor(user.getVendor());
            
            productService.saveProduct(product);
        
        return "redirect:/vendor/product";
    }
    
    
    
    @RequestMapping("/product/view/{productId}")
    public String productList(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "productView";
    }
    

}
