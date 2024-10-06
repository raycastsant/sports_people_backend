package com.sportspeople.main.repository;

import org.springframework.data.repository.CrudRepository;
import com.sportspeople.main.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}