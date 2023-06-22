package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;

import java.util.UUID;

public interface FetchPersonUseCase {
    Response execute(Request request);

    record Request(UUID personId) {}

    record Response(Person person) {}
}
