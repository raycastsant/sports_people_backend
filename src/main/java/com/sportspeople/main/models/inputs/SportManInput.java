package com.sportspeople.main.models.inputs;

import java.util.Set;

import com.sportspeople.main.models.SportManMedals;

import lombok.Data;

/** Class used to handle the SportMan insert/update request body */
@Data
public class SportManInput {
    private Integer countryId;
    // private Set<SportManMedals> sportManMedals;
    private String name;
    private Integer age;
    private String description;
}
