package com.example.pluggedinserver.repositories;

import com.example.pluggedinserver.models.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    @Query("select owner from Owner owner")
    public List<Owner> findAllOwners();

    @Query("select owner from Owner owner " +
            "where owner.username=:username " +
            "and owner.password=:password")
    public Owner findOwnerByCredentials
            (@Param("username") String username,
             @Param("password") String password);

    @Query("select owner from Owner owner " +
            "where owner.id=:id")
    public Owner findOwnerById
            (@Param("id") Integer id);

}
