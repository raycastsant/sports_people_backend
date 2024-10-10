package com.sportspeople.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.repository.SportCategoryRepository;

@Service("sportCategoryService")
public class SportCategoryService {

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    public Iterable<SportCategory> getAllCategories() {
        return sportCategoryRepository.findAll();
    }

    public Optional<SportCategory> findById(int id) {
        return sportCategoryRepository.findById(id);
    }

    public SportCategory saveSportCategory(SportCategory sportCategory) {
        return sportCategoryRepository.save(sportCategory);
    }
}