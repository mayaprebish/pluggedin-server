package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    VenueRepository repository;



}
