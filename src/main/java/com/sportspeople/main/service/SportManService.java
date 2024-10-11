package com.sportspeople.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.Country;
import com.sportspeople.main.models.SportMan;
import com.sportspeople.main.models.inputs.SportManInput;
import com.sportspeople.main.repository.SportmanRepository;

@Service("sportManService")
public class SportManService {

    @Autowired
    private SportmanRepository sportManRepository;

    public Iterable<SportMan> getAllSportMen() {
        return sportManRepository.findAll();
    }

    public Optional<SportMan> findById(int id) {
        return sportManRepository.findById(id);
    }

    public SportMan saveSportMan(SportMan sportMan) {
        return sportManRepository.save(sportMan);
    }

    public SportMan updateSportMan(SportManInput input, Country country, int id) {
        final SportMan result = sportManRepository.findById(id).orElse(null);
        if (result != null) {
            result.setCountry(country);
            result.setName(input.getName());
            result.setAge(input.getAge());
            result.setDescription(input.getDescription());
            return saveSportMan(result);
        } else {
            return result;
        }
    }

    public Boolean deleteSportMan(SportMan sportMan) {
        if (null != sportMan) {
            sportManRepository.delete(sportMan);
            return true;
        }

        return false;
    }
}