package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.models.Owner;
import com.example.pluggedinserver.repositories.ManagerRepository;
import com.example.pluggedinserver.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("/api/users/managers")
    public List<Manager> getAllManagers() {
        return managerRepository.findAllManagers();
    }

    @GetMapping("/api/users/owners")
    public List<Owner> getAllOwners() {
        return ownerRepository.findAllOwners();
    }

    @PostMapping("/api/users/managers")
    public List<Manager> createManagerUser
            (@RequestBody Manager manager) {
        managerRepository.save(manager);
        return managerRepository.findAllManagers();
    }

    @PostMapping("/api/users/owners")
    public List<Owner> createOwnerUser
            (@RequestBody Owner owner) {
        ownerRepository.save(owner);
        return ownerRepository.findAllOwners();
    }

    @GetMapping("/api/users/managers/{id}")
    public Manager getManagerById
            (@PathVariable("id") Integer id) {
        return managerRepository.findManagerById(id);
    }

    @GetMapping("/api/users/owners/{id}")
    public Owner getOwnerById
            (@PathVariable("id") Integer id) {
        return ownerRepository.findOwnerById(id);
    }

    @GetMapping("/api/users/manager")
    public Manager getManagerByCredentials
            (@RequestBody String username,
             @RequestBody String password) {
        return managerRepository.findManagerByCredentials(username, password);
    }

    @GetMapping("/api/users/owner")
    public Owner getOwnerByCredentials
            (@RequestBody String username,
             @RequestBody String password) {
        return ownerRepository.findOwnerByCredentials(username, password);
    }
}
