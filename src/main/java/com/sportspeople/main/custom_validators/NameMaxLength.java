package com.sportspeople.main.custom_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Interface to validate the name's max length
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameMaxLengthValidator.class)
public @interface NameMaxLength {
    int maxLength() default 50;

    String message() default "The name must not have more than 50 characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}