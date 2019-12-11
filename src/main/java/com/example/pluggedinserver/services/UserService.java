package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.*;
import com.example.pluggedinserver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    VenueRepository venueRepository;
    @Autowired
    TourRepository tourRepository;
    @Autowired
    BookingRepository bookingRepository;

    TourService tourService;

    public UserService() {
    }

    public List<Venue> createOwnerVenue(Integer ownerId, Venue venue) {

        Owner owner = ownerRepository.findOwnerById(ownerId);
        List<Venue> originalVenues = owner.getVenues();
        originalVenues.add(venue);
        owner.setVenues(originalVenues);
        ownerRepository.save(owner);

        Owner updatedOwner = ownerRepository.findOwnerById(ownerId);
        venue.setOwner(updatedOwner);
        venueRepository.save(venue);
        return venueRepository.findAllByOwner(ownerId);
    }

    public List<Venue> deleteOwnerVenue(Integer ownerId, Integer venueId) {
        venueRepository.deleteVenue(venueId, ownerId);
        return venueRepository.findAllByOwner(ownerId);
    }

    public List<Venue> updateOwnerVenue(Integer ownerId, Integer venueId, Venue venue) {
        Owner owner = this.getOwnerById(ownerId);
        venueRepository.deleteVenue(venueId, ownerId);
        venueRepository.save(venue);
        return venueRepository.findAllByOwner(ownerId);
    }

    public List<Tour> createManagerTour(Integer managerId, Tour tour) {
        Manager manager = this.getManagerById(managerId);
        Tour t = new Tour(tour.getTitle(), manager);
        tourRepository.save(t);
        return tourRepository.findAllToursForManager(managerId);
    }

    public List<Tour> createBooking(Integer managerId, Integer tourId, Booking booking) {
        Tour tour = tourService.findTourForManager(managerId, tourId);
        Venue venue = booking.getVenue();
        Owner owner = null;
        List<Venue> venues = venueRepository.findAllVenues();
        if (venues.size() > 0) {
            owner = venueRepository.findVenueById(venue.getId()).getOwner();
        }
        Booking b = new Booking(booking.getArtist(), booking.getVenue(), tour, owner);
        bookingRepository.save(b);
        return tourRepository.findAllToursForManager(managerId);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAllManagers();
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAllOwners();
    }

    public Manager createManagerUser
            (Manager manager) {
        managerRepository.save(manager);
        return manager;
    }

    public Owner createOwnerUser
            (Owner owner) {
        ownerRepository.save(owner);
        return owner;
    }

    public Manager getManagerById
            (Integer id) {
        return managerRepository.findManagerById(id);
    }

    public Owner getOwnerById
            (Integer id) {
        return ownerRepository.findOwnerById(id);
    }

    public User getUserByCredentials
            (String username,
             String password) {
        if (managerRepository.findManagerByCredentials(username, password) == null) {
            return ownerRepository.findOwnerByCredentials(username, password);
        } else {
            return managerRepository.findManagerByCredentials(username, password);
        }
    }

    public Manager getManagerByCredentials
            (String username,
             String password) {
        return managerRepository.findManagerByCredentials(username, password);
    }

    public Owner getOwnerByCredentials
            (String username,
             String password) {
        return ownerRepository.findOwnerByCredentials(username, password);
    }

}
