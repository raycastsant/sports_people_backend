package com.sportspeople.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.Country;
import com.sportspeople.main.repository.CountryRepository;

@Service("countryService")
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}