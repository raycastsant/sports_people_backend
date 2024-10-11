package com.sportspeople.main.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedalType {
    // GOLD, SILVER, BRONZE;
    GOLD("GOLD"), SILVER("SILVER"), BRONZE("BRONZE");

    private final String value;

    // MedalType(String jsonValue) {
    // this.jsonValue = jsonValue;
    // }

    @JsonValue
    public String getValue() {
        System.out.println("DIOS TE AMA");
        return value;
    }

    @Override
    public String toString() {
        System.out.println("DIOS TE AMA");
        return String.valueOf(value);
    }

    @JsonCreator
    public static MedalType fromValue(String value) {
        System.out.println("DIOS TE AMA");
        for (MedalType b : MedalType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
