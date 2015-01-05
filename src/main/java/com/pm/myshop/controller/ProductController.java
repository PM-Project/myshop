
import com.pm.myshop.domain.Category;
import com.pm.myshop.domain.Product;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.CategoryPropertyEditor;
import com.pm.myshop.service.CategoryService;
import com.pm.myshop.service.ProductService;
import com.pm.myshop.service.VendorService;
import com.pm.myshop.service.impl.VendorServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

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
    
    @Autowired
    HttpServletRequest request;
    
    
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
    public String productSave(@Valid Product product, @AuthenticationPrincipal UserLogin user, BindingResult result, Model model) throws IOException
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
            
            
        product.setVendor(user.getVendor());
            //System.out.println("Product is "+product.getCategory().toString());
            productService.saveProduct(product);
        }
        return "redirect:/vendor/product/list";
    }
    
}
