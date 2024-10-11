package com.sportspeople.main.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sportspeople.main.controller.helpers.ResponseHelper;
import com.sportspeople.main.models.Medal;
import com.sportspeople.main.models.SportCategory;
import com.sportspeople.main.models.SportMan;
import com.sportspeople.main.models.inputs.MedalsInput;
import com.sportspeople.main.service.MedalsService;
import com.sportspeople.main.service.SportCategoryService;
import com.sportspeople.main.service.SportManService;
import jakarta.validation.Valid;

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

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> addNewMedals(@Valid @RequestBody MedalsInput input) {
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
        medalData.setSportMan(sportMan.get());
        medalData.setEventName(input.getEventName());
        medalData.setDate(input.getDate());
        // medalData.setMedalType(input.getMedalType());
        medalData.setMedalType("GOLD");
        medalData = medalsService.saveMedals(medalData);

        return ResponseHelper.generateResponse("Successfully saved data!", HttpStatus.OK, medalData);
    }
}