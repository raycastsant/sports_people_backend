package com.sportspeople.main.models;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sportspeople.main.custom_validators.NameMaxLength;
import com.sportspeople.main.custom_validators.NameMinLength;
import com.sportspeople.main.custom_validators.NameSpecialCharacters;
import com.sportspeople.main.models.enums.MedalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "medals")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sport_man_id")
    private SportMan sportman;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "medal_type")
    private MedalType medalType;
}
