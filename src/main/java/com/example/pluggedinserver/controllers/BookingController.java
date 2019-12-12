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

    @GetMapping("api/tours/{tid}/bookings")
    public List<Booking> findAllBookingsForTour(@PathVariable("tid") Integer tid) {
        return service.findAllBookingsForTour(tid);
    }

    @GetMapping("api/venues/{vid}/bookings")
    public List<Booking> findAllBookingsForVenue(@PathVariable("vid") Integer vid) {
        return service.findAllBookingsForVenue(vid);
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
