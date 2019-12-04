package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class VenueController {
    @Autowired
    VenueRepository repository;

    // find a manager's favorited venues, or find an owner's owned venue
}
