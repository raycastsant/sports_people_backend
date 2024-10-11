package com.sportspeople.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportspeople.main.controller.helpers.ResponseHelper;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.models.inputs.SportCategoryInput;
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

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> readCategory(@PathVariable int id) {
        final Optional<SportCategory> category = categoryService.findById(id);
        if (category.isEmpty()) {
            return ResponseHelper.generateResponse("Category with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    category);
        } else {
            return ResponseHelper.generateResponse("OK", HttpStatus.OK, category);
        }
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<SportCategory> addNewSportCategory(@Valid @RequestBody SportCategory category) {
        return ResponseEntity.ok(categoryService.saveSportCategory(category));
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody ResponseEntity<Object> updateCategory(@Valid @RequestBody SportCategoryInput input,
            @PathVariable int id) {
        final SportCategory category = categoryService.updateCategory(input, id);
        if (null == category) {
            return ResponseHelper.generateResponse("Category with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    category);
        } else {
            return ResponseHelper.generateResponse("Category updated.", HttpStatus.OK, category);
        }
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        final SportCategory category = categoryService.findById(id).orElse(null);
        final Boolean result = categoryService.deleteSportCategory(category);
        if (!result) {
            return ResponseHelper.generateResponse("Could not delete Category with Id " + id, HttpStatus.NOT_FOUND,
                    result);
        } else {

            return ResponseHelper.generateResponse("Category deleted.", HttpStatus.OK, result);
        }
    }
}