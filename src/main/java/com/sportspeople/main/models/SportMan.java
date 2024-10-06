package com.sportspeople.main.models;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
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

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "sportMan", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<SportManMedals> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "description")
    private String description;
}
