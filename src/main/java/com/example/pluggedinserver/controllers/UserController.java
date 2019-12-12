package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.*;
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

    @PostMapping("/api/users/owners/{ownerId}/venue")
    public List<Venue> createVenue
            (@PathVariable("ownerId") Integer ownerId,
             @RequestBody Venue venue) {
        return service.createOwnerVenue(ownerId, venue);
    }

    @DeleteMapping("/api/users/owners/{ownerId}/venues/{venueId}")
    public List<Venue> deleteVenue
            (@PathVariable("ownerId") Integer ownerId,
             @PathVariable("venueId") String venueId) {
        return service.deleteOwnerVenue(ownerId, venueId);
    }

    @PutMapping("/api/users/owners/{ownerId}/venues/{venueId}")
    public List<Venue> updateVenue
            (@PathVariable("ownerId") Integer ownerId,
             @PathVariable("venueId") String venueId,
             @RequestBody Venue venue) {
        return service.updateOwnerVenue(ownerId, venueId, venue);
    }

    @PostMapping("/api/users/managers/{managerId}/tour")
    public List<Tour> createManagerTour
            (@PathVariable("managerId") Integer managerId,
             @RequestBody Tour tour) {
        return service.createManagerTour(managerId, tour);
    }

    @PostMapping("/api/users/managers/{managerId}/tours/{tourId}/booking")
    public List<Tour> createBooking
            (@PathVariable("managerId") Integer managerId,
             @PathVariable("tourId") Integer tourId,
             @RequestBody Booking booking) {
        return service.createBooking(managerId, tourId, booking);
    }

}
