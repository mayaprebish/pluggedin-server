package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    @Autowired
    TourRepository repository;
}
