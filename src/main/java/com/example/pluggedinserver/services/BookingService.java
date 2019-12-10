package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.*;
import com.example.pluggedinserver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    ArtistRepository artistRepository;

    public List<Booking> createBookingForOwner(Integer oid, Booking booking) {

        Owner owner = ownerRepository.findOwnerById(oid);
        List<Booking> originalBookings = owner.getBookings();
        originalBookings.add(booking);
        owner.setBookings(originalBookings);
        ownerRepository.save(owner);

        Owner updatedOwner = ownerRepository.findOwnerById(oid);
        booking.setOwner(updatedOwner);
        repository.save(booking);
        return repository.findAllBookingsForOwner(oid);
    }

    public List<Booking> findAllBookingsForOwner(Integer oid) {
        return repository.findAllBookingsForOwner(oid);
    }

    public List<Booking> createBookingForTour(Integer tid, Booking booking) {

        Tour tour = tourRepository.findTourById(tid);
        List<Booking> originalBookings = tour.getBookings();
        originalBookings.add(booking);
        tour.setBookings(originalBookings);
        tourRepository.save(tour);

        Tour updatedTour = tourRepository.findTourById(tid);
        booking.setTour(updatedTour);
        repository.save(booking);
        return repository.findAllBookingsForTour(tid);
    }

    public List<Booking> findAllBookingsForTour(Integer tid) {
        return repository.findAllBookingsForTour(tid);
    }

    public List<Booking> createBookingForVenue(Integer vid, Booking booking) {

        Venue venue = venueRepository.findVenueById(vid);
        List<Booking> originalBookings = venue.getBookings();
        originalBookings.add(booking);
        venue.setBookings(originalBookings);
        venueRepository.save(venue);

        Venue updatedVenue = venueRepository.findVenueById(vid);
        booking.setVenue(updatedVenue);
        repository.save(booking);
        return repository.findAllBookingsForVenue(vid);
    }

    public List<Booking> findAllBookingsForVenue(Integer vid) {
        return repository.findAllBookingsForVenue(vid);
    }

    public List<Booking> createBookingForArtist(Integer aid, Booking booking) {

        Artist artist = artistRepository.findArtistById(aid);
        List<Booking> originalBookings = artist.getBookings();
        originalBookings.add(booking);
        artist.setBookings(originalBookings);
        artistRepository.save(artist);

        Artist updatedArtist = artistRepository.findArtistById(aid);
        booking.setArtist(updatedArtist);
        repository.save(booking);
        return repository.findAllBookingsForArtist(aid);
    }

    public List<Booking> findAllBookingsForArtist(Integer aid) {
        return repository.findAllBookingsForArtist(aid);
    }

    public List<Booking> findAllBookings() {
        return repository.findAllBookings();
    }

    public Booking findBookingById(Integer bid) {
        return repository.findBookingById(bid);
    }

    public Booking updateBooking(Integer bid, Booking booking) {
        Booking curBooking = this.findBookingById(bid);

        curBooking.setId(booking.getId());
        curBooking.setArtist(booking.getArtist());
        curBooking.setOwner(booking.getOwner());
        curBooking.setTour(booking.getTour());
        curBooking.setVenue(booking.getVenue());

        repository.save(curBooking);
        return curBooking;
    }

    public List<Booking> deleteBooking(Integer bid) {
        repository.deleteById(bid);
        return (List<Booking>)repository.findAll();
    }
}
