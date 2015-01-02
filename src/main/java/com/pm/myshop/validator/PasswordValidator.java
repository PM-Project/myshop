/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.validator;

import com.pm.myshop.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author kunda_000
 */
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "This field can't be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypepassword", "field.required", "This field can't be blank");
        
        
        
    }
    
}
