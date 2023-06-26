package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getByCity(@RequestParam("city") String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getByAge(@RequestParam("age") int age) {
        return repository.findYoungerThan(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.findByFullname(name, surname);
    }
}
