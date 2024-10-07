package com.sportspeople.main.models;

import java.util.Set;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sportspeople.main.custom_validators.NameValidCharacters;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<SportMan> sportMen;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameValidCharacters
    public String name;

}
