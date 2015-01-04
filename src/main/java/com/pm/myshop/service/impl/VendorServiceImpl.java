/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.service.impl;

import com.pm.myshop.dao.VendorDao;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jagendra
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {
    
     @Autowired
    VendorDao vendorDao;

    @Override
    public void saveVendor(Vendor vendor) {
        vendorDao.saveVendor(vendor);
    }

    @Override
    public Vendor getVendorById(int id) {
        return vendorDao.getVendorById(id);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorDao.getAllVendors();
    }

    @Override
    public void deleteVendor(int id) {
        vendorDao.deleteVendor(id);
    }      

    @Override
    public Vendor mergeVendor(Vendor vendor) {
        return vendorDao.mergeVendor(vendor);
    }
    
}
