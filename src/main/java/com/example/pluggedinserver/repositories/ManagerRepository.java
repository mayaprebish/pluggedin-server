package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {

}
