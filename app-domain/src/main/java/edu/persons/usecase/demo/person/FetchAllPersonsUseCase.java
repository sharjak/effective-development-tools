package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;

import java.util.List;

public interface FetchAllPersonsUseCase {
    Response execute();

    record Response(List<Person> persons) {}
}
