package com.example.pluggedinserver.models;

import javax.persistence.*;
import java.util.List;

// a venue is an object with a name and a location
@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    // artists that have played at this venue
    @ManyToMany
    private List<Artist> artists;

    public Venue(){}
}
