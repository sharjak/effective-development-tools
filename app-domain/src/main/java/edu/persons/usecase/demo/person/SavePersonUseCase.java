package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;

public interface SavePersonUseCase {
    Response execute(Request request);

    record Request(Person person) {}

    record Response(Person person) {}
}
