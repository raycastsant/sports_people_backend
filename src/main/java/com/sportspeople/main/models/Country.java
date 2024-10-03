package com.sportspeople.main.models;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    private String name;
}
