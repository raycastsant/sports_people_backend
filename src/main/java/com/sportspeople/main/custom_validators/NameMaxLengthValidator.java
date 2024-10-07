package com.sportspeople.main.custom_validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Class to validate the name's max length
 * numbers
 */
public class NameMaxLengthValidator implements ConstraintValidator<NameMaxLength, String> {
    int maxLength;

    @Override
    public void initialize(NameMaxLength constraintAnnotation) {
        this.maxLength = constraintAnnotation.maxLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.trim().length() <= maxLength;
    }
}