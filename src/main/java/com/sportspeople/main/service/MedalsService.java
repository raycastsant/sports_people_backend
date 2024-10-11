package com.sportspeople.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.Medal;
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
}