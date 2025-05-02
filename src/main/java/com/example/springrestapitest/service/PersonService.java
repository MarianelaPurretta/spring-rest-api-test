package com.example.springrestapitest.service;

import com.example.springrestapitest.model.Person;
import com.example.springrestapitest.model.Movie;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final Map<Long, Person> people = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();
    private final int maxMoviesPerPerson = 5; // valor configurable

    // Listar personas ordenadas por apellido y nombre
    public List<Person> getAllPeople() {
        return people.values().stream()
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(people.get(id));
    }

    public List<Person> findByName(String name) {
        return people.values().stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public Person createPerson(Person person) {
        long id = idGenerator.incrementAndGet();
        person.setId(id);
        people.put(id, person);
        return person;
    }

    public Optional<Person> updatePerson(Long id, Person newData) {
        if (!people.containsKey(id)) return Optional.empty();

        Person existing = people.get(id);
        if (newData.getFirstName() != null) existing.setFirstName(newData.getFirstName());
        if (newData.getLastName() != null) existing.setLastName(newData.getLastName());
        if (newData.getBirthdate() != null) existing.setBirthdate(newData.getBirthdate());
        existing.setHasInsurance(newData.isHasInsurance());

        return Optional.of(existing);
    }

    public boolean deletePerson(Long id) {
        return people.remove(id) != null;
    }

    // Películas
    public List<Movie> getMovies(Long id) {
        return people.containsKey(id) ? people.get(id).getFavouriteMovies() : null;
    }

    public boolean addMovie(Long id, Movie movie) {
        Person person = people.get(id);
        if (person != null && person.getFavouriteMovies().size() < maxMoviesPerPerson) {
            person.getFavouriteMovies().add(movie);
            return true;
        }
        return false;
    }

    public boolean removeMovie(Long id, String title) {
        Person person = people.get(id);
        if (person == null) return false;

        return person.getFavouriteMovies().removeIf(m -> m.getTitle().equalsIgnoreCase(title));
    }
}
