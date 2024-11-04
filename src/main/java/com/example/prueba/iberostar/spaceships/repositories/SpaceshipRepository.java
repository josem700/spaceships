package com.example.prueba.iberostar.spaceships.repositories;

import com.example.prueba.iberostar.spaceships.entities.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
    @Query("SELECT s FROM Spaceship s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Spaceship> findByNameInIgnoreCase(@Param("name") String name);
}