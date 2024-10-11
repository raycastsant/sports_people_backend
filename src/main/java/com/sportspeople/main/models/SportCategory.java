package com.sportspeople.main.models;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Medal> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameSpecialCharacters
    @NameMinLength
    @NameMaxLength
    private String name;
}
