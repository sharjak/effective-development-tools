package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;
import edu.persons.model.person.PersonsFilter;

import java.util.List;

public interface FetchAllPersonsUseCase {
    Response execute(Request request);

    record Request(PersonsFilter filter) {}

    record Response(List<Person> persons) {}
}
