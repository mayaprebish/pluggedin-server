package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class VenueController {

    @Autowired
    VenueService service;

    @GetMapping("/api/venues/search/{searchPhrase}")
    public String getAllVenues(@PathVariable("searchPhrase") String searchPhrase) {

        return service.getAllVenues(searchPhrase);
    }


    @GetMapping("/api/venues/{vid}")
    public String getVenue(@PathVariable("vid") String vid) {
        return service.getVenue(vid);
    }
}
