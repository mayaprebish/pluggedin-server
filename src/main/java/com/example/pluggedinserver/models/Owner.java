package com.example.pluggedinserver.models;

import javax.persistence.*;

// a type of pluggedin user who owns a venue and can keep track of bookings on pluggedin
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Venue venue;
    // many bookings

    public Owner() {}
}
