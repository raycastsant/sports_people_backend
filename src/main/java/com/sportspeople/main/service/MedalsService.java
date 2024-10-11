package com.sportspeople.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.Medal;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.models.SportMan;
import com.sportspeople.main.models.inputs.MedalInput;
import com.sportspeople.main.repository.MedalsRepository;

@Service("medalsService")
public class MedalsService {

    @Autowired
    private MedalsRepository medalsRepository;

    public Iterable<Medal> getAllMedals() {
        return medalsRepository.findAll();
    }

    public Optional<Medal> findById(int id) {
        return medalsRepository.findById(id);
    }

    public Medal saveMedals(Medal medals) {
        return medalsRepository.save(medals);
    }

    public Medal updateMedal(MedalInput input, SportMan sportMan, SportCategory category, int id) {
        final Medal result = medalsRepository.findById(id).orElse(null);
        if (result != null) {
            result.setSportman(sportMan);
            result.setCategory(category);
            result.setDate(input.getDate());
            result.setEventName(input.getEventName());
            result.setMedalType(input.getMedalType());
            return saveMedals(result);
        } else {
            return result;
        }
    }

    public Boolean deleteMedal(Medal medal) {
        if (null != medal) {
            medalsRepository.delete(medal);
            return true;
        }

        return false;
    }
}