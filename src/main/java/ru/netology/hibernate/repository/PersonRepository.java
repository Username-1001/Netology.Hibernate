package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String city);
    @Query("SELECT  p FROM Person p WHERE p.id.age < :age ORDER BY p.id.age")
    List<Person> findYoungerThan(@Param("age") int age);
    @Query("SELECT p FROM Person p WHERE  p.id.name = :name AND p.id.surname = :surname")
    Optional<Person> findByFullname(@Param("name") String name, @Param("surname") String surname);
}
