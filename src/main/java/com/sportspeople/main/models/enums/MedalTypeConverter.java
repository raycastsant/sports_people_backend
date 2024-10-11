package com.sportspeople.main.models.enums;

import org.apache.coyote.BadRequestException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MedalTypeConverter implements
        AttributeConverter<MedalType, String> {

    // @Override
    // public String convertToDatabaseColumn(MedalType attribute) {
    // if (attribute == null) {
    // throw new BadRequestException("Please provide a valid User Role.");
    // }

    //
    // }

    @Override
    public MedalType convertToEntityAttribute(String value) {
        return MedalType.valueOf(value);
    }

    @Override
    public String convertToDatabaseColumn(MedalType attribute) {
        return attribute.toString();
    }
}