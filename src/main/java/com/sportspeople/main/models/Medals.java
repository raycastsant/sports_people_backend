package com.sportspeople.main.models;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "medals")
public class Medals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "medals", cascade = CascadeType.ALL)
    private Set<SportManMedals> sportManMedals;

    @NotNull
    @Column(name = "gold")
    private int gold;

    @NotNull
    @Column(name = "silver")
    private int silver;

    @NotNull
    @Column(name = "bronze")
    private int bronze;
}
