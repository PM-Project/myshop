/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.validator;

import com.pm.myshop.domain.Customer;
import com.pm.myshop.domain.UserLogin;
import com.pm.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author kunda_000
 */
public class UserValidator implements Validator {

    UserService userService;
    
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    
    
    @Override
    public boolean supports(Class<?> type) {
        return Customer.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "This field can't be blank");
        Customer customer = (Customer) o;
        UserLogin user = userService.getUserByUsername(customer.getEmail());
        if(user != null)
            errors.rejectValue("email","customer.email", "User Name already registered. Please choose different email of forget password.");
        
    }
    
}
