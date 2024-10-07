package com.sportspeople.main.models;

import java.util.Set;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sportspeople.main.custom_validators.NameValidCharacters;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sport_men")
public class SportMan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "sportMan", cascade = CascadeType.ALL)
    private Set<SportManMedals> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameValidCharacters
    private String name;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "description")
    private String description;
}
