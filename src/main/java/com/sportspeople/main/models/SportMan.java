package com.sportspeople.main.models;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import com.sportspeople.main.custom_validators.NameMaxLength;
import com.sportspeople.main.custom_validators.NameMinLength;
import com.sportspeople.main.custom_validators.NameSpecialCharacters;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "sportman", cascade = CascadeType.ALL)
    private List<Medal> sportManMedals;

    @Length(max = 100)
    @NotNull
    @Column(name = "name")
    @NameSpecialCharacters
    @NameMinLength
    @NameMaxLength
    private String name;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "description")
    private String description;
}
