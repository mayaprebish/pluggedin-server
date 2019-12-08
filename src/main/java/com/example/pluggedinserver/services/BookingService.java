package com.example.pluggedinserver.services;

import com.example.pluggedinserver.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;
}
