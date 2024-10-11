package com.sportspeople.main.models.inputs;

import java.sql.Date;

import com.sportspeople.main.models.enums.MedalType;

import lombok.Data;

/** Class used to handle the Medals insert/update request body */
@Data
public class MedalsInput {
    private int sportManId;
    private int sportCategoryId;
    private String eventName;
    private Date date;
    private MedalType medalType;
}
