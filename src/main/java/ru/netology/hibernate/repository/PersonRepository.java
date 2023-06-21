package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("SELECT p FROM Person p where lower(p.cityOfLiving) = lower(?1)", Person.class)
                .setParameter(1, city)
                .getResultList();
    }
}
