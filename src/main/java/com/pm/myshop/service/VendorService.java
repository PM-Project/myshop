/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service;

import com.pm.myshop.domain.Vendor;
import java.util.List;

/**
 *
 * @author Jagendra
 */
public interface VendorService {
    
    public void saveVendor(Vendor vendor);
    public Vendor getVendorById(int id);
    public List<Vendor> getAllVendors(); 
    public void deleteVendor(int id);   
    public Vendor mergeVendor(Vendor vendor);
    
}
