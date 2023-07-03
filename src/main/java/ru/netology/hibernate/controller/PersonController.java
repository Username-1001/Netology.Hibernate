package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;
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
    @Secured("READ")
    public List<Person> getByCity(@RequestParam("city") String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("WRITE")
    public List<Person> getByAge(@RequestParam("age") int age) {
        return repository.findYoungerThan(age);
    }

    @GetMapping("/persons/by-name-surname")
    @PostAuthorize("returnObject.get().id.name == authentication.principal.username")
    public Optional<Person> getByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.findByFullname(name, surname);
    }

    @PostMapping("/persons/delete")
    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public void deleteById(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age) {
        PersonId id = new PersonId();
        id.setName(name);
        id.setSurname(surname);
        id.setAge(age);
        repository.deleteById(id);
    }
}
