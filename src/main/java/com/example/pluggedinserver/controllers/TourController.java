package com.example.pluggedinserver.controllers;

import com.example.pluggedinserver.models.Tour;
import com.example.pluggedinserver.repositories.TourRepository;
import com.example.pluggedinserver.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class TourController {

    TourService service;

    @PostMapping("api/users/managers/{mid}/tours")
    public List<Tour> createTourForManager(@PathVariable("mid") Integer mid,
                                           @RequestBody Tour tour) {
        return service.createTourForManager(mid, tour);
    }

    @GetMapping("api/users/managers/{mid}/tours")
    public List<Tour> findAllToursForManager(@PathVariable("mid") Integer mid) {
        return service.findAllToursForManager(mid);
    }

    @GetMapping("api/tours/{tid}")
    public Tour findTourById(@PathVariable("tid") Integer tid) {
        return service.findTourById(tid);
    }

    @PutMapping("api/tours/{tid}")
    public Tour updateTour(@PathVariable("tid") Integer tid, @RequestBody Tour tour) {
        return service.updateTour(tid, tour);
    }

    @DeleteMapping("api/tours/{tid}")
    public List<Tour> deleteTour(@PathVariable("tid") Integer tid) {
        return service.deleteTour(tid);
    }
}
