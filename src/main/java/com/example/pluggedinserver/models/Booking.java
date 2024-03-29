package com.example.pluggedinserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.Date;


/**
 * A Booking represents an event at a Venue with an Artist. A Booking is part of a Tour, and a Venue Owner's profile
 * contains a list of Bookings.
 */
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @ManyToOne
    @JsonIgnore
    private Artist artist;

    @ManyToOne
    @JsonIgnore
    private Venue venue;

    @ManyToOne
    @JsonIgnore
    private Owner owner;

    @ManyToOne
    @JsonIgnore
    private Tour tour;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Booking() {}

    public Booking(Artist artist, Venue venue, Tour tour, Owner owner, Date date) {
        this.artist = artist;
        this.venue = venue;
        this.tour = tour;
        this.owner = owner;
        this.date = date;
    }
}
