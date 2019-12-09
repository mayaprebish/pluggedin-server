package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.models.Owner;
import com.example.pluggedinserver.models.User;
import com.example.pluggedinserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/api/users/managers")
    public List<Manager> getAllManagers() {
        return service.getAllManagers();
    }

    @GetMapping("/api/users/owners")
    public List<Owner> getAllOwners() {
        return service.getAllOwners();
    }

    @PostMapping("/api/users/manager")
    public Manager registerNewManager
            (@RequestBody Manager manager) {
        Manager m = new Manager(manager.getUsername(), manager.getPassword(), manager.getFirstName(),
                manager.getLastName());
        return service.createManagerUser(m);
    }

    @PostMapping("/api/users/owner")
    public Owner registerNewOwner
            (@RequestBody Owner owner) {
        Owner o = new Owner(owner.getUsername(), owner.getPassword(), owner.getFirstName(), owner.getLastName());
        return service.createOwnerUser(o);
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
            (@PathVariable("username") String username,
             @PathVariable("password") String password) {

        Manager manager = service.getManagerByCredentials(username, password);
        if (manager != null) {
            return manager;
        } else {
            return service.getOwnerByCredentials(username, password);
        }
    }

    @GetMapping("/api/users/manager")
    public Manager getManagerByCredentials
            (@RequestParam String username,
             @RequestBody String password) {
        return service.getManagerByCredentials(username, password);
    }

    @GetMapping("/api/users/owner")
    public Owner getOwnerByCredentials
            (@RequestParam String username,
             @RequestParam String password) {
        return service.getOwnerByCredentials(username, password);
    }
}
