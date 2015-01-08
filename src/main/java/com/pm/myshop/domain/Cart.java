/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Santosh
 */
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToOne
    private Customer customer;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, LineItem> lineItems = new HashMap<Integer, LineItem>();

    private float subTotal;

    private float taxRate;
    
    private float taxAmount;
    
    private float grandTotal;
    
    private int totalItems;

    public Map<Integer, LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Map<Integer, LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void addLineItem(LineItem item) {
        item.setCart(this);
        Integer productId = item.getProduct().getId();

        if (lineItems.containsKey(productId)) {
            LineItem existingLineItem = lineItems.get(productId);
            existingLineItem.setQuantity(existingLineItem.getQuantity() + item.getQuantity());
            lineItems.put(productId, existingLineItem);
            existingLineItem.updateAmount();
        } else {
            lineItems.put(productId, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(LineItem item) {
        Integer productId = item.getProduct().getId();
        lineItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        subTotal = 0;
        totalItems = 0;
        for (LineItem item : lineItems.values()) {
            subTotal += item.getAmount();
            totalItems += item.getQuantity();
        }
        taxAmount = subTotal * taxRate / 100;
        grandTotal = subTotal + taxAmount;
    }

    
    
    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }
    
    public void mergeCartItems(Cart cart)
    {
        for(LineItem item : cart.getLineItems().values())
        {
            addLineItem(new LineItem(item.getProduct(),item.getQuantity()));
        }
        updateGrandTotal();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    

}
