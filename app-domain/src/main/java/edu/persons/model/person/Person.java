package edu.persons.model.person;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
public class Person {
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
