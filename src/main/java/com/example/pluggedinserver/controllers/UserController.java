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

    @PostMapping("/api/user")
    public User registerNewUser
            (@RequestBody String userType,
             @RequestBody String username,
             @RequestBody String password,
             @RequestBody String firstName,
             @RequestBody String lastName) {
        if (userType.equals("Venue Owner")) {
            Owner owner = new Owner(username, password, firstName, lastName);
            return service.createOwnerUser(owner);
        } else if (userType.equals("Tour Manager")) {
            Manager manager = new Manager(username, password, firstName, lastName);
            return service.createManagerUser(manager);
        } else {
            return null;
        }
    }

//    @PostMapping("/api/users/managers")
//    public List<Manager> createManagerUser
//            (@RequestBody Manager manager) {
//        return service.createManagerUser(manager);
//    }
//
//    @PostMapping("/api/users/owners")
//    public List<Owner> createOwnerUser
//            (@RequestBody Owner owner) {
//        return service.createOwnerUser(owner);
//    }

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

    @GetMapping("/api/users/{username}/{password}/{userType}")
    public User getUserByCredentials
            (@PathVariable("username") String username,
             @PathVariable("password") String password,
             @PathVariable("userType") String userType) {
        if (userType.equals("Venue Owner")) {
            return service.getOwnerByCredentials(username, password);
        } else if (userType.equals("Tour Manager")) {
            return service.getManagerByCredentials(username, password);
        } else {
            return null;
        }
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
