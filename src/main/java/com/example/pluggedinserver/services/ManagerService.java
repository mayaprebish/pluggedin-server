package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository repository;
}
