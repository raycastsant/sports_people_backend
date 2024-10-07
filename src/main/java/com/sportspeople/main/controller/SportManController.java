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
import com.sportspeople.main.controller.utils.ResponseUtils;
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

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> addNewSportMan(@Valid @RequestBody SportManInput input) {
        // search for a valid country
        final Optional<Country> country = countryService.findById(input.getCountryId());
        if (country.isEmpty()) {
            return ResponseUtils.generateResponse("Could not get the country with ID: " + input.getCountryId(),
                    HttpStatus.OK, input);
        } else {

            SportMan sportMan = new SportMan();
            sportMan.setCountry(country.get());
            sportMan.setName(input.getName());
            sportMan.setAge(input.getAge());
            sportMan.setDescription(input.getDescription());

            sportMan = sportManService.saveSportMan(sportMan);
            return ResponseUtils.generateResponse("Successfully retrieved data!", HttpStatus.OK, sportMan);
        }
    }
}
