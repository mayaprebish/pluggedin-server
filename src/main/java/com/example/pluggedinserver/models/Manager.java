package com.example.pluggedinserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private List<Artist> artists;
    private List<Tour> tours;
    private List<Booking> bookings;
    private List<Venue> venues;
}
