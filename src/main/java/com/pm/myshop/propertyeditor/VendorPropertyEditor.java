/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.propertyeditor;

import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.VendorService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Jagendra
 */
public class VendorPropertyEditor extends PropertyEditorSupport {
    
    private VendorService vendorService;

    public VendorPropertyEditor(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    
    
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        int id = Integer.parseInt(text);
        Vendor vendor = vendorService.getVendorById(id);
        setValue(vendor);
    }
    
}
