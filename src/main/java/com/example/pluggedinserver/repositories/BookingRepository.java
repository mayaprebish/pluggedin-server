package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
