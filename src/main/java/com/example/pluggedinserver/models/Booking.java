package com.example.pluggedinserver.models;

import javax.persistence.*;

// a booking represents one event with one artist at one venue, which is part of one tour
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Artist artist;
    private Venue venue;
    private Tour tour;

    public Booking() {}
}
