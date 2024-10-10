package com.sportspeople.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.service.SportCategoryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private SportCategoryService categoryService;

    @GetMapping("/all")
    public @ResponseBody Iterable<SportCategory> getAllCountries(boolean sorted) {
        return categoryService.getAllCategories();
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<SportCategory> addNewSportCategory(@Valid @RequestBody SportCategory category) {
        return ResponseEntity.ok(categoryService.saveSportCategory(category));
    }
}