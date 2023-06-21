package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons", schema = "public")
public class Person {
    @Id
    @Column(length = 30, nullable = false)
    private String name;
    @Id
    @Column(length = 30, nullable = false)
    private String surname;
    @Id
    @Check(constraints = "age > 0")
    private int age;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @Column(name = "city_of_living", length = 30, nullable = false)
    private String cityOfLiving;
}
