package com.example.pluggedinserver.models;

import javax.persistence.*;
import java.util.List;

// a type of pluggedin user who manages a list of artists, keeps track of tours, and can favorite venues
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
    private List<Venue> venues;

    // many artists (stored in profile)
    // many tours (series of bookings)
    // many 'favorited' venues

    public Manager() {}
}
