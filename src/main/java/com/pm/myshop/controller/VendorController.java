/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.controller;

import com.pm.myshop.domain.Vendor;
import com.pm.myshop.propertyeditor.VendorPropertyEditor;
import com.pm.myshop.service.VendorService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
 * @author Jagendra
 */
@Controller
public class VendorController {
    
    
    @Autowired
    VendorService vendorService;
    
    @InitBinder
    public void initConverter(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));        
    } 
    
    @RequestMapping("/vendor/add")
    public String vendorAdd(Vendor vendor)
    {
        return "/vendor/form";
    }
    
    @RequestMapping(value = "/vendor/save", method = RequestMethod.POST)
    public String saveUser(@Valid Vendor vendor, BindingResult result)
    {
        if(result.hasErrors())
            return "vendor/form";
        else
           vendorService.saveVendor(vendor);    
        return "redirect:/vendor/list";
    }
    
    @RequestMapping(value = "/vendor/list")
    public String listUsers(Model model)
    {
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "vendor/list";
    }
    
    @RequestMapping("/vendor/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") int id, Model model)
    {
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "vendor/form";
    }
    
    @RequestMapping("/vendor/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") int id, Model model)
    {
        vendorService.deleteVendor(id);
        return "redirect:/vendor/list";
    }
    
}
