package com.sportspeople.main.custom_validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Class to validate that the name does not contain special characters or
 * numbers
 */
public class NameCharactersValidator implements ConstraintValidator<NameValidCharacters, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name.matches("[aA-zZ ']+$");
    }
}