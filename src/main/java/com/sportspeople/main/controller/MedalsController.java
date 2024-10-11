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
import org.springframework.web.bind.annotation.ResponseBody;
import com.sportspeople.main.controller.helpers.ResponseHelper;
import com.sportspeople.main.models.Medal;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.models.SportMan;
import com.sportspeople.main.models.inputs.MedalInput;
import com.sportspeople.main.service.MedalsService;
import com.sportspeople.main.service.SportCategoryService;
import com.sportspeople.main.service.SportManService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/medals")
public class MedalsController {
    @Autowired
    private MedalsService medalsService;

    @Autowired
    private SportManService sportManService;

    @Autowired
    private SportCategoryService categoryService;

    @GetMapping("/all")
    public @ResponseBody Iterable<Medal> getAllmedals() {
        return medalsService.getAllMedals();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> readMedal(@PathVariable int id) {
        final Optional<Medal> medal = medalsService.findById(id);
        if (medal.isEmpty()) {
            return ResponseHelper.generateResponse("Medal with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    medal);
        } else {
            return ResponseHelper.generateResponse("OK", HttpStatus.OK, medal);
        }
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> addNewMedals(@Valid @RequestBody MedalInput input) {
        // search for a valid SportCategoy
        final Optional<SportCategory> category = categoryService.findById(input.getSportCategoryId());
        if (category.isEmpty()) {
            return ResponseHelper.generateResponse("Could not get the category with ID: "
                    + input.getSportCategoryId(),
                    HttpStatus.OK, input);
        }

        // search for a valid SportMan
        final Optional<SportMan> sportMan = sportManService.findById(input.getSportManId());
        if (sportMan.isEmpty()) {
            return ResponseHelper.generateResponse("Could not get the sport man with ID: " + input.getSportManId(),
                    HttpStatus.OK, input);
        }

        Medal medalData = new Medal();
        medalData.setCategory(category.get());
        medalData.setSportman(sportMan.get());
        medalData.setEventName(input.getEventName());
        medalData.setDate(input.getDate());
        medalData.setMedalType(input.getMedalType());
        medalData = medalsService.saveMedals(medalData);

        return ResponseHelper.generateResponse("Successfully saved data!", HttpStatus.OK, medalData);
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody ResponseEntity<Object> updatemedal(@Valid @RequestBody MedalInput input,
            @PathVariable int id) {
        // search for a valid category
        final SportCategory category = categoryService.findById(input.getSportCategoryId()).orElse(null);
        if (null == category) {
            return ResponseHelper.generateResponse("Could not get the category with ID: " + input.getSportCategoryId(),
                    HttpStatus.OK, input);
        }

        // search for a valid sport man
        final SportMan sportMan = sportManService.findById(input.getSportManId()).orElse(null);
        if (null == sportMan) {
            return ResponseHelper.generateResponse("Could not get the sport man with ID: " + input.getSportManId(),
                    HttpStatus.OK, input);
        }

        final Medal medal = medalsService.updateMedal(input, sportMan, category, id);
        if (null == medal) {
            return ResponseHelper.generateResponse("Medal man with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    medal);
        } else {
            return ResponseHelper.generateResponse("OK", HttpStatus.OK, medal);
        }
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> deleteMedal(@PathVariable int id) {
        final Medal medal = medalsService.findById(id).orElse(null);
        final Boolean result = medalsService.deleteMedal(medal);
        if (!result) {
            return ResponseHelper.generateResponse("Could not delete Medal with Id " + id, HttpStatus.NOT_FOUND,
                    result);
        } else {

            return ResponseHelper.generateResponse("Medal deleted.", HttpStatus.OK, result);
        }
    }
}