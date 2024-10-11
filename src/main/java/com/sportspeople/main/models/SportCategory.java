package com.sportspeople.main.models;

import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sportspeople.main.custom_validators.NameMaxLength;
import com.sportspeople.main.custom_validators.NameMinLength;
import com.sportspeople.main.custom_validators.NameSpecialCharacters;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sport_categories", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class SportCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Medal> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameSpecialCharacters
    @NameMinLength
    @NameMaxLength
    private String name;
}
