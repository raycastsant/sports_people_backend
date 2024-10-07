package com.sportspeople.main.service;

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

    public SportMan saveSportMan(SportMan sportMan) {
        return sportManRepository.save(sportMan);
    }
}