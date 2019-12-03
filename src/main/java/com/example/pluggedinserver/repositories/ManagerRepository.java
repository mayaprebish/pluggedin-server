package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {

    @Query("select manager from Manager manager " +
            "where manager.username=:username " +
            "and manager.password=:password")
    public List<Manager> findManagerByCredentials
            (@Param("username") String username,
             @Param("password") String password);
}
