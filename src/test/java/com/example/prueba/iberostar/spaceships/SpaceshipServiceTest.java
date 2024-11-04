package com.example.prueba.iberostar.spaceships;

import com.example.prueba.iberostar.spaceships.entities.Spaceship;
import com.example.prueba.iberostar.spaceships.repositories.SpaceshipRepository;
import com.example.prueba.iberostar.spaceships.services.SpaceshipService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SpaceshipServiceTest {

    @Mock
    private SpaceshipRepository repository;

    @InjectMocks
    private SpaceshipService service;

    @Test
    public void testGetSpaceshipById(){
        Spaceship spaceship = new Spaceship();
        spaceship.setId(1L);
        spaceship.setName("X-Wing");

        when(repository.findById(1L)).thenReturn(Optional.of(spaceship));

        Spaceship result = service.getSpaceshipById(1L);
        assertEquals("X-Wing", result.getName());
    }
}
