package com.sportspeople.main.models.inputs;

import lombok.Data;

/** Class used to handle the SportMan insert/update request body */
@Data
public class SportManInput {
    private Integer countryId;
    private String name;
    private Integer age;
    private String description;
}
