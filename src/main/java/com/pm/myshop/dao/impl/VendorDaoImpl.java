/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.dao.impl;

import com.pm.myshop.dao.VendorDao;
import com.pm.myshop.domain.Vendor;
import com.pm.myshop.util.SessionUtil;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jagendra
 */
@Repository
public class VendorDaoImpl extends SessionUtil implements VendorDao{

    @Override
    public void saveVendor(Vendor vendor) {
        getSession().saveOrUpdate(vendor);
    }

    @Override
    public Vendor getVendorById(int id) {
        return (Vendor) getSession().get(Vendor.class, id);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return getSession().createQuery("From Vendor").list();
    }

    @Override
    public void deleteVendor(int id) {
        Vendor vendor=getVendorById(id);
        if(vendor!=null)
        getSession().delete(vendor);
        
    }
    
}
