package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.models.Tour;
import com.example.pluggedinserver.repositories.ManagerRepository;
import com.example.pluggedinserver.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    TourRepository repository;

    @Autowired
    ManagerRepository managerRepository;

    public List<Tour> createTourForManager(Integer mid, Tour tour) {

        Manager manager = managerRepository.findManagerById(mid);
        List<Tour> originalTours = manager.getTours();
        originalTours.add(tour);
        manager.setTours(originalTours);
        managerRepository.save(manager);

        Manager updatedManager = managerRepository.findManagerById(mid);
        tour.setManager(updatedManager);
        repository.save(tour);
        return repository.findAllToursForManager(mid);

    }

    public List<Tour> findAllToursForManager(Integer mid) {
        return repository.findAllToursForManager(mid);
    }

    public Tour findTourById(Integer tid) {
        return repository.findTourById(tid);
    }

    public Tour findTourForManager(Integer mid, Integer tid) {
        return repository.findTourForManager(mid, tid);
    }

    public Tour updateTour(Integer tid, Tour tour) {
        Tour curTour = this.findTourById(tid);

        curTour.setId(tour.getId());
        curTour.setManager(tour.getManager());
        curTour.setBookings(tour.getBookings());
        curTour.setTitle(tour.getTitle());

        repository.save(curTour);
        return curTour;
    }

    public List<Tour> deleteTour(Integer tid) {
        repository.deleteById(tid);
        return (List<Tour>)repository.findAll();
    }
}
