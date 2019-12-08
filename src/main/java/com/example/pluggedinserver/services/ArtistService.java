package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository repository;
}
