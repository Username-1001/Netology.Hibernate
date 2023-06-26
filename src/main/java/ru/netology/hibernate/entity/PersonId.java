package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class PersonId implements Serializable {
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String surname;
    @Check(constraints = "age > 0")
    private int age;
}
