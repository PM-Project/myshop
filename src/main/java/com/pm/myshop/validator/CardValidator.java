/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.validator;

import com.pm.myshop.domain.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kunda_000
 */
public class CardValidator implements Validator {

    

    @Override
    public void validate(Object o, Errors errors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supports(Class<?> type) {
        return String.class.equals(type);
    }
    
}
