package com.example.pluggedinserver.models;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Tour() {}
}
