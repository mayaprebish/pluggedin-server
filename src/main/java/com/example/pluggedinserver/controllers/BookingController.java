package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Booking;
import com.example.pluggedinserver.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class BookingController {
    @Autowired
    BookingService service;

    @PostMapping("api/users/owners/{oid}/bookings")
    public List<Booking> createBookingForOwner(@PathVariable("oid") Integer oid,
                                               @RequestBody Booking booking) {
        return service.createBookingForOwner(oid, booking);
    }

    @GetMapping("api/users/owners/{oid}/bookings")
    public List<Booking> findAllBookingsForOwner(@PathVariable("oid") Integer oid) {
        return service.findAllBookingsForOwner(oid);
    }

    @PostMapping("api/tours/{tid}/bookings")
    public List<Booking> createBookingForTour(@PathVariable("tid") Integer tid,
                                              @RequestBody Booking booking) {
        return service.createBookingForTour(tid, booking);
    }

    @GetMapping("api/tours/{tid}/bookings")
    public List<Booking> findAllBookingsForTour(@PathVariable("tid") Integer tid) {
        return service.findAllBookingsForTour(tid);
    }

    @PostMapping("api/venues/{vid}/bookings")
    public List<Booking> createBookingForVenue(@PathVariable("vid") Integer vid,
                                              @RequestBody Booking booking) {
        return service.createBookingForVenue(vid, booking);
    }

    @GetMapping("api/venues/{vid}/bookings")
    public List<Booking> findAllBookingsForVenue(@PathVariable("vid") Integer vid) {
        return service.findAllBookingsForVenue(vid);
    }

    @PostMapping("api/artists/{aid}/bookings")
    public List<Booking> createBookingForArtist(@PathVariable("aid") Integer aid,
                                               @RequestBody Booking booking) {
        return service.createBookingForArtist(aid, booking);
    }

    @GetMapping("api/artists/{aid}/bookings")
    public List<Booking> findAllBookingsForArtist(@PathVariable("aid") Integer aid) {
        return service.findAllBookingsForArtist(aid);
    }

    @GetMapping("api/bookings")
    public List<Booking> findAllBookings() {
        return service.findAllBookings();
    }

    @GetMapping("api/bookings/{bid}")
    public Booking findBookingById(@PathVariable("bid") Integer bid) {
        return service.findBookingById(bid);
    }

    @PutMapping("api/bookings/{bid}")
    public Booking updateBooking(@PathVariable("bid") Integer bid, @RequestBody Booking booking) {
        return service.updateBooking(bid, booking);
    }

    @DeleteMapping("api/bookings/{bid}")
    public List<Booking> deleteBooking(@PathVariable("bid") Integer bid) {
        return service.deleteBooking(bid);
    }
}
