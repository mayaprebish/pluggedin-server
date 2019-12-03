package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class BookingController {
    @Autowired
    BookingRepository repository;

}
