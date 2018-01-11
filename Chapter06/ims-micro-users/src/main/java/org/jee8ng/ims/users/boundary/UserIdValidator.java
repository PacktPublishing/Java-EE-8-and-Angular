/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.users.boundary;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author prashantp
 */
public class UserIdValidator implements ConstraintValidator<UserId, Long> {
    
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value > 10;
    }
}
