package com.sportspeople.main.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedalType {
    GOLD("GOLD"), SILVER("SILVER"), BRONZE("BRONZE");
    // GOLD, SILVER, BRONZE;

    private final String value;

    // MedalType(String jsonValue) {
    // this.jsonValue = jsonValue;
    // }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static MedalType fromValue(String value) {
        for (MedalType b : MedalType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
