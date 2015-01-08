/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Santosh
 */
@Entity
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int quantity;
    private float rate;
    private float amount;

    public LineItem() {
    }
    
    
    public LineItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.rate = product.getSellingPrice();
        updateAmount();
    }
    
    public LineItem(Product product,int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.rate = product.getSellingPrice();
        updateAmount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineItem)) {
            return false;
        }
        LineItem other = (LineItem) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pm.myshop.domain.LineItem[ id=" + id + " ]";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        rate = product.getSellingPrice();
        updateAmount();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateAmount();
    }

    public float getAmount() {
        return amount;
    }

    public void updateAmount() {
        this.amount = rate * quantity;
    }

    public float getRate() {
        return rate;
    }

    public void setRate() {
        this.rate = product.getSellingPrice();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
