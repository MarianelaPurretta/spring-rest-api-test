package com.example.springrestapitest.controller;

import com.example.springrestapitest.model.Movie;
import com.example.springrestapitest.model.Person;
import com.example.springrestapitest.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    // Listar personas (ordenadas)
    @GetMapping
    public List<Person> getAll() {
        return service.getAllPeople();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        return service.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por nombre
    @GetMapping("/search")
    public List<Person> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    // Crear persona
    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.createPerson(person);
    }

    // Modificar persona
    @PatchMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person newData) {
        return service.updatePerson(id, newData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar persona
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.deletePerson(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Mostrar películas de una persona
    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getMovies(@PathVariable Long id) {
        List<Movie> movies = service.getMovies(id);
        return movies != null ? ResponseEntity.ok(movies) : ResponseEntity.notFound().build();
    }

    // Agregar película a persona
    @PostMapping("/{id}/movies")
    public ResponseEntity<String> addMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return service.addMovie(id, movie)
                ? ResponseEntity.ok("Película agregada")
                : ResponseEntity.badRequest().body("No se pudo agregar la película (límite alcanzado?)");
    }

    // Quitar película por título
    @DeleteMapping("/{id}/movies")
    public ResponseEntity<String> removeMovie(@PathVariable Long id, @RequestParam String title) {
        return service.removeMovie(id, title)
                ? ResponseEntity.ok("Película eliminada")
                : ResponseEntity.notFound().build();
    }
}
