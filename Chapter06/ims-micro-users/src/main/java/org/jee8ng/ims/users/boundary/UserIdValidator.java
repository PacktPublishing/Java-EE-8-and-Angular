package org.jee8ng.ims.users.boundary;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author prashantp.org
 */
public class UserIdValidator implements ConstraintValidator<UserId, Long> {
    
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value > 10;
    }
}
