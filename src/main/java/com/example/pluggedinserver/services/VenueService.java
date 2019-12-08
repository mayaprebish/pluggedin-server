package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.Venue;
import com.example.pluggedinserver.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    VenueRepository repository;
    RestTemplate restTemplate = new RestTemplate();


    public String getAllVenues(String searchPhrase) {

        final String uri = "https://api.eventful.com/json/venues/search?app_key=4TTVttfmr3tXFDJr" + "&keywords=" + searchPhrase;

        String result = restTemplate.getForObject(uri, String.class);

        return result;

    }


    public String getVenue(String venueId) {

        final String uri = "http://api.eventful.com/json/venues/get?app_key=4TTVttfmr3tXFDJr&id=" + venueId;

        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }
}
