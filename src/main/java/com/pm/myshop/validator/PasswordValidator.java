/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pm.myshop.validator;

import com.pm.myshop.domain.UserLogin;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author kunda_000
 */
public class PasswordValidator implements Validator {

    private static final int MINIMUM_PASSWORD_LENGTH = 6;
    
    @Override
    public boolean supports(Class type) {
        return UserLogin.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "This field can't be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "verification", "field.required", "This field can't be blank");
        
        UserLogin user = (UserLogin) o;
        if(user.getPassword() != null && user.getPassword().length() < MINIMUM_PASSWORD_LENGTH)
            errors.rejectValue("password","password.length", "Password must be more than 5 characters");
        else if(!user.getPassword().equals(user.getVerification()))
            errors.rejectValue("password","password.verification", "Password verification not matched");
        
        
    }
    
}
