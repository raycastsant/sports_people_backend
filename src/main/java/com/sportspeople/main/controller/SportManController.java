package com.sportspeople.main.controller;

import java.util.HashMap;
import java.util.Iterator;
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
import com.sportspeople.main.models.Country;
import com.sportspeople.main.models.SportMan;
import com.sportspeople.main.models.inputs.SportManInput;
import com.sportspeople.main.service.CountryService;
import com.sportspeople.main.service.SportManService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/sport-men")
public class SportManController {

    @Autowired
    private SportManService sportManService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public @ResponseBody Iterable<SportMan> getAllSportMen() {
        return sportManService.getAllSportMen();
    }

    @GetMapping("/all/indexed-by-id")
    public @ResponseBody HashMap<Long, SportMan> getAllSportMenindexed() {
        final Iterator<SportMan> sportMen = sportManService.getAllSportMen().iterator();
        final HashMap<Long, SportMan> result = new HashMap<>();
        while (sportMen.hasNext()) {
            final SportMan spman = sportMen.next();
            result.put(spman.getId(), spman);
        }

        return result;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> readSportMan(@PathVariable int id) {
        final Optional<SportMan> sportMan = sportManService.findById(id);
        if (sportMan.isEmpty()) {
            return ResponseHelper.generateResponse("Sport Man with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    sportMan);
        } else {
            return ResponseHelper.generateResponse("OK", HttpStatus.OK, sportMan);
        }
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> addNewSportMan(@Valid @RequestBody SportManInput input) {
        // search for a valid country
        final Optional<Country> country = countryService.findById(input.getCountryId());
        if (country.isEmpty()) {
            return ResponseHelper.generateResponse("Could not get the country with ID: " + input.getCountryId(),
                    HttpStatus.OK, input);
        } else {
            SportMan sportMan = new SportMan();
            sportMan.setCountry(country.get());
            sportMan.setName(input.getName());
            sportMan.setAge(input.getAge());
            sportMan.setDescription(input.getDescription());

            sportMan = sportManService.saveSportMan(sportMan);
            return ResponseHelper.generateResponse("Successfully saved data!", HttpStatus.OK, sportMan);
        }
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody ResponseEntity<Object> updateSportMan(@Valid @RequestBody SportManInput input,
            @PathVariable int id) {
        final Country country = countryService.findById(input.getCountryId()).orElse(null);
        if (null == country) {
            return ResponseHelper.generateResponse("Could not get the country with ID: " + input.getCountryId(),
                    HttpStatus.OK, input);
        }

        final SportMan sportMan = sportManService.updateSportMan(input, country, id);
        if (null == sportMan) {
            return ResponseHelper.generateResponse("Sport man with Id " + id + " does not exist.", HttpStatus.NOT_FOUND,
                    sportMan);
        } else {
            return ResponseHelper.generateResponse("OK", HttpStatus.OK, sportMan);
        }
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> deleteSportMan(@PathVariable int id) {
        final SportMan sportMan = sportManService.findById(id).orElse(null);
        final Boolean result = sportManService.deleteSportMan(sportMan);
        if (!result) {
            return ResponseHelper.generateResponse("Could not delete Sport Man with Id " + id, HttpStatus.NOT_FOUND,
                    result);
        } else {

            return ResponseHelper.generateResponse("Sport Man deleted.", HttpStatus.OK, result);
        }
    }
}
