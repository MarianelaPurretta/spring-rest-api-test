package com.example.springrestapitest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private boolean hasInsurance;
    private List<Movie> favouriteMovies = new ArrayList<>();

    // Constructores
    public Person() {}

    public Person(Long id, String firstName, String lastName, LocalDate birthdate, boolean hasInsurance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.hasInsurance = hasInsurance;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public List<Movie> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<Movie> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }
}
