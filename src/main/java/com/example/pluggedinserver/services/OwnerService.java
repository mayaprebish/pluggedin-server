package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository repository;
}
