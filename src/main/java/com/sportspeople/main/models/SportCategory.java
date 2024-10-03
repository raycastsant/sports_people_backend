package com.sportspeople.main.models;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sport_categories")
public class SportCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST,
            CascadeType.MERGE })
    private Set<SportManMedals> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    private String name;
}
