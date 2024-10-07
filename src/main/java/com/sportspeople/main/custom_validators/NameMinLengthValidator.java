package com.sportspeople.main.custom_validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Class to validate the name's min length
 * numbers
 */
public class NameMinLengthValidator implements ConstraintValidator<NameMinLength, String> {
    int minLength;

    @Override
    public void initialize(NameMinLength constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.trim().length() >= minLength;
    }
}