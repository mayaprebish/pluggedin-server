package com.example.pluggedinserver.models;

import javax.persistence.*;

// a venue is an object with a name and a location
@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    public Venue(){}
}
