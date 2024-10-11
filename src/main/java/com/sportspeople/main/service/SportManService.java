package com.sportspeople.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.SportMan;
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

}