package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Artist;
import com.example.pluggedinserver.repositories.ArtistRepository;
import com.example.pluggedinserver.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ArtistController {
    ArtistService service;

}
