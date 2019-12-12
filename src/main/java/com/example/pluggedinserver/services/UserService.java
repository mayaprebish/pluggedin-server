package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.*;
import com.example.pluggedinserver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
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
    @Autowired
    ArtistRepository artistRepository;

    TourService tourService;
    VenueService venueService;

    public UserService() {
    }

    public Owner createOwnerVenue(Integer ownerId, Venue venue) {
        Owner owner = ownerRepository.findOwnerById(ownerId);
        Venue v = new Venue(venue.getStringKey(), venue.getName(), venue.getLocation(), owner);
        venueRepository.save(v);
        return ownerRepository.findOwnerById(ownerId);
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

    public Manager createTour(Integer managerId, Tour tour) {
        Manager manager = this.getManagerById(managerId);
        Tour t = new Tour(tour.getTitle(), manager);
        tourRepository.save(t);
        return manager;
    }

    public Manager deleteTour(Integer managerId, Integer tourId) {
        tourRepository.deleteTour(tourId, managerId);
        return this.getManagerById(managerId);
    }

    public Manager createBooking(Integer managerId, Integer tourId, Integer artistId, String venueKey,
                                 Booking booking) {
        Manager m = managerRepository.findManagerById(managerId);
        Tour t = tourRepository.findTourById(tourId);
        Artist a = artistRepository.findArtistById(artistId);
        Venue v = venueRepository.findVenueByKey(venueKey);
        Owner o = null;
        if (v != null) {
            o = v.getOwner();
        }

        Date d = booking.getDate();
        Booking b = new Booking(a, v, t, o, d);
        bookingRepository.save(b);

        return m;
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
