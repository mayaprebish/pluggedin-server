package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.models.Owner;
import com.example.pluggedinserver.models.User;
import com.example.pluggedinserver.repositories.ManagerRepository;
import com.example.pluggedinserver.repositories.OwnerRepository;
import com.example.pluggedinserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
    UserService service;

    @GetMapping("/api/users/managers")
    public List<Manager> getAllManagers() {
        return service.getAllManagers();
    }

    @GetMapping("/api/users/owners")
    public List<Owner> getAllOwners() {
        return service.getAllOwners();
    }

    @PostMapping("/api/users/managers")
    public List<Manager> createManagerUser
            (@RequestBody Manager manager) {
        return service.createManagerUser(manager);
    }

    @PostMapping("/api/users/owners")
    public List<Owner> createOwnerUser
            (@RequestBody Owner owner) {
        return service.createOwnerUser(owner);
    }

    @GetMapping("/api/users/managers/{id}")
    public Manager getManagerById
            (@PathVariable("id") Integer id) {
        return service.getManagerById(id);
    }

    @GetMapping("/api/users/owners/{id}")
    public Owner getOwnerById
            (@PathVariable("id") Integer id) {
        return service.getOwnerById(id);
    }

    @GetMapping("/api/users/{username}/{password}")
    public User getUserByCredentials
            (@PathVariable String username,
             @PathVariable String password) {
        return service.getUserByCredentials(username, password);
    }

    @GetMapping("/api/users/manager")
    public Manager getManagerByCredentials
            (@RequestBody String username,
             @RequestBody String password) {
        return service.getManagerByCredentials(username, password);
    }

    @GetMapping("/api/users/owner")
    public Owner getOwnerByCredentials
            (@RequestBody String username,
             @RequestBody String password) {
        return service.getOwnerByCredentials(username, password);
    }
}
