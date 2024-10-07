package com.sportspeople.main.custom_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Interface to validate the name's min length
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameMinLengthValidator.class)
public @interface NameMinLength {
    int minLength() default 3;

    String message() default "The name must have at least 3 characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}