package com.sportspeople.main.models;

import java.util.Set;
import org.hibernate.validator.constraints.Length;
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

    @OneToMany(mappedBy = "country", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<SportMan> sportMen;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    public String name;
}
