package com.sportspeople.main.custom_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Interface to validate that the name does not contain special characters or
 * numbers
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameCharactersValidator.class)
public @interface NameValidCharacters {
    String message() default "The name must not contain numbers or special characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}