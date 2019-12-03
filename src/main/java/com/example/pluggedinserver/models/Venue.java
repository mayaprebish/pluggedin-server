package com.example.pluggedinserver.models;

import javax.persistence.*;

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
