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


    public String getAllVenues(String searchPhrase) {

        final String uri = "https://api.eventful.com/json/venues/search?app_key=4TTVttfmr3tXFDJr&l=boston" + "&keywords=" + searchPhrase;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;

    }
}
