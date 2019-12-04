package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.repositories.ManagerRepository;
import com.example.pluggedinserver.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    OwnerRepository ownerRepository;

    // find and add users
}
