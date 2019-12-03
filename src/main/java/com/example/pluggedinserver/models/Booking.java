package com.example.pluggedinserver.models;

import javax.persistence.*;

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
