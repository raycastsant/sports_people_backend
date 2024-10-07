package com.sportspeople.main.custom_validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Class to validate that the name does not contain special characters or
 * numbers
 */
public class NameSpecialCharactersValidator implements ConstraintValidator<NameSpecialCharacters, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name.matches("[aA-zZ ']+$");
    }
}