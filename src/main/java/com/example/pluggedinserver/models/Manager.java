package com.example.pluggedinserver.models;

import javax.persistence.*;
import java.util.List;

// a type of pluggedin user who manages a list of artists, keeps track of tours, and can favorite venues
@Entity
@Table(name = "managers")
public class Manager implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "manager")
    private List<Artist> artists;

    @OneToMany(mappedBy = "manager")
    private List<Tour> tours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    @OneToMany(mappedBy = "manager")
    private List<Venue> venues;

    // many artists (stored in profile)
    // many tours (series of bookings)
    // many 'favorited' venues

    public Manager() {}
}
