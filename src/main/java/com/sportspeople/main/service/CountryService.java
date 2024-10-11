package com.sportspeople.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.Country;
import com.sportspeople.main.models.inputs.CountryInput;
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

    public Country updateCountry(CountryInput input, int id) {
        final Country result = countryRepository.findById(id).orElse(null);
        if (result != null) {
            result.setName(input.getName());
            return saveCountry(result);
        } else {
            return result;
        }
    }

    public Boolean deleteCountry(Country country) {
        if (null != country) {
            countryRepository.delete(country);
            return true;
        }

        return false;
    }
}