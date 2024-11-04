package com.example.prueba.iberostar.spaceships.controllers;

import com.example.prueba.iberostar.spaceships.entities.Spaceship;
import com.example.prueba.iberostar.spaceships.services.SpaceshipService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class SpaceshipController {

    @Autowired
    private SpaceshipService service;

    @GetMapping("/all")
    @Operation(summary = "Obtiene todas las naves espaciales existentes", description = "Obtiene todas las naves espaciales en la base de datos")
    public Page<Spaceship> getAll(Pageable pageable){
        return service.getAllShips(pageable);
    }

    @Operation(summary = "Obtener una nave espacial por ID", description = "Devuelve una nave espacial específica mediante su ID")
    @GetMapping("/{id}")
    public Spaceship getById(@PathVariable Long id){
        return service.getSpaceshipById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar una nave espacial por nombre", description = "Busca una nave espacial específica mediante su nombre")
    public List<Spaceship> search(@RequestParam("name") String name){
        List<Spaceship> a = service.getSpaceshipByName(name);
        System.out.println(a);
        return service.getSpaceshipByName(name);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva nave espacial", description = "Crea y guarda una nueva nave espacial en la base de datos")
    public Spaceship create(@RequestBody Spaceship spaceship){
        return service.createSpaceship(spaceship);
    }


    @PostMapping("/multiple")
    @Operation(summary = "Crear varias naves espaciales", description = "Crea y guarda varias naves espaciales en la base de datos")
    public List<Spaceship> createMultiple(@RequestBody List<Spaceship> spaceships){
        return service.createMultipleSpaceships(spaceships);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica una nave espacial existente", description = "Modifica una nave espacial en la base de datos")
    public Spaceship update(@PathVariable Long id, @RequestBody Spaceship spaceship){
        return service.updateSpaceship(id, spaceship);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra una nave espacial existente", description = "Borra una nave espacial en la base de datos")
    public Spaceship delete(@PathVariable Long id){
        return service.deleteSpaceship(id);
    }
}
