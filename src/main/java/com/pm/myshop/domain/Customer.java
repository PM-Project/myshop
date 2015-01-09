/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pm.myshop.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */

@Entity
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @NotEmpty
    private String name;
    
    @Email(message = "{User.email.notvalid}")
    @NotEmpty(message = "{User.username.empty}")
    private String email;
    
    @Pattern(regexp="(^$|[0-9]{10})",message = "{Phone.notvalid}")
    private String phone;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL)
    private UserLogin user;
    
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart pendingCart;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UserLogin getUser() {
        return user;
    }

    public void setUser(UserLogin user) {
        this.user = user;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }
    
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pm.myshop.entity.Customer[ id=" + id + " ]";
    }

    public Cart getPendingCart() {
        return pendingCart;
    }

    public void setPendingCart(Cart pendingCart) {
        this.pendingCart = pendingCart;
    }
    
}
