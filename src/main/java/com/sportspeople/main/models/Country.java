package com.sportspeople.main.models;

import java.util.List;
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
@Table(name = "countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<SportMan> sportMen;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameSpecialCharacters
    @NameMinLength
    @NameMaxLength
    public String name;
}
