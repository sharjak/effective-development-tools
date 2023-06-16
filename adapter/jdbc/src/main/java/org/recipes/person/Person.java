package org.recipes.person;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
