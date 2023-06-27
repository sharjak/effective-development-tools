package edu.persons.port;

import edu.persons.model.person.Person;

import java.util.UUID;

public interface FetchPersonPort {

    Person fetch(UUID personId);
}
