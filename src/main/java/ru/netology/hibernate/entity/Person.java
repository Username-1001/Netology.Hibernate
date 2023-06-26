package ru.netology.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons", schema = "public")
public class Person {
    @EmbeddedId
    private PersonId id;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @Column(name = "city_of_living", length = 30, nullable = false)
    private String cityOfLiving;
}
