package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class TourController {
    @Autowired
    TourRepository repository;

    // find and store tours by manager id
}
