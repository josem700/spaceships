package com.example.prueba.iberostar.spaceships.services;

import com.example.prueba.iberostar.spaceships.entities.Spaceship;
import com.example.prueba.iberostar.spaceships.repositories.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceshipService {

    @Autowired
    private SpaceshipRepository repository;

    @Cacheable("spaceships")
    public Page<Spaceship> getAllShips(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Spaceship getSpaceshipById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Spaceship not found"));
    }

    public List<Spaceship> getSpaceshipByName(String name){
        return repository.findByNameInIgnoreCase(name);
    }

    public Spaceship createSpaceship(Spaceship spaceship) {
        return repository.save(spaceship);
    }

    public List<Spaceship> createMultipleSpaceships(List<Spaceship> spaceships){
        return repository.saveAll(spaceships);
    }

    public Spaceship updateSpaceship(Long id, Spaceship spaceship){
        Spaceship existingShip = getSpaceshipById(id);
        existingShip.setName(spaceship.getName());
        existingShip.setSeries(spaceship.getSeries());
        return repository.save(existingShip);
    }

    public Spaceship deleteSpaceship(Long id){
        Spaceship existingSpaceship = getSpaceshipById(id);
        repository.deleteById(id);
        return existingSpaceship;
    }

}
