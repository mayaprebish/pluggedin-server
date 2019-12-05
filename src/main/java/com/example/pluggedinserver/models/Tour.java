package com.example.pluggedinserver.models;

import javax.persistence.*;
import java.util.List;

// a tour is a series of bookings
// tour has a title, a list of bookings
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "tour")
    private List<Booking> bookings;
    // many bookings
    // one manager

    public Tour() {}
}
