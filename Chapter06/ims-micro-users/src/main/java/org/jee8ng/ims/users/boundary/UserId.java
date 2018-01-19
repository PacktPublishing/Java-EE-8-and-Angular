package org.jee8ng.ims.users.boundary;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author prashantp.org
 */
@Documented
@Constraint(validatedBy = UserIdValidator.class)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {

    String message() default "Invalid User Id, should be greather than 10";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
