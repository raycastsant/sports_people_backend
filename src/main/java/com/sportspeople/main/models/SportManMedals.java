package com.sportspeople.main.models;

import java.sql.Date;

import com.sportspeople.main.custom_validators.NameMaxLength;
import com.sportspeople.main.custom_validators.NameMinLength;
import com.sportspeople.main.custom_validators.NameSpecialCharacters;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sport_man_medals")
public class SportManMedals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sport_man_id")
    private SportMan sportMan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medals_id")
    private Medals medals;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private SportCategory category;

    @NotNull
    @Column(name = "event_name")
    @NameSpecialCharacters
    @NameMinLength
    @NameMaxLength(maxLength = 100)
    private String eventName;

    @NotNull
    @Column(name = "date")
    private Date date;
}
