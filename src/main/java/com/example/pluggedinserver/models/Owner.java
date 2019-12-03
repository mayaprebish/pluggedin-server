package com.example.pluggedinserver.models;

import javax.persistence.*;

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
}
