package com.example.pluggedinserver.services;

import com.example.pluggedinserver.models.Manager;
import com.example.pluggedinserver.models.Owner;
import com.example.pluggedinserver.models.User;
import com.example.pluggedinserver.repositories.ManagerRepository;
import com.example.pluggedinserver.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    OwnerRepository ownerRepository;

    public UserService() {

    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAllManagers();
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAllOwners();
    }

    public List<Manager> createManagerUser
            (Manager manager) {
        managerRepository.save(manager);
        return managerRepository.findAllManagers();
    }

    public List<Owner> createOwnerUser
            (Owner owner) {
        ownerRepository.save(owner);
        return ownerRepository.findAllOwners();
    }

    public Manager getManagerById
            (Integer id) {
        return managerRepository.findManagerById(id);
    }

    public Owner getOwnerById
            (Integer id) {
        return ownerRepository.findOwnerById(id);
    }

    public User getUserByCredentials
            (String username,
             String password) {
        if (managerRepository.findManagerByCredentials(username, password) == null) {
            return ownerRepository.findOwnerByCredentials(username, password);
        }
        else {
            return managerRepository.findManagerByCredentials(username, password);
        }
    }

    public Manager getManagerByCredentials
            (String username,
             String password) {
        return managerRepository.findManagerByCredentials(username, password);
    }

    public Owner getOwnerByCredentials
            (String username,
             String password) {
        return ownerRepository.findOwnerByCredentials(username, password);
    }

}
