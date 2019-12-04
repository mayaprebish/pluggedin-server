package com.example.pluggedinserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private String genre;

    // this artist's manager
    @ManyToOne
    @JsonIgnore
    private Manager manager;

    // venues that this artist has played at
    @ManyToMany
    private List<Venue> venues;

    // many venues
    // one manager

    public Artist() {}
}
