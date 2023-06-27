package edu.persons.port;

import edu.persons.model.person.Person;
import edu.persons.model.person.PersonsFilter;

import java.util.List;

public interface FetchAllPersonsPort {

    List<Person> fetchAllPersons(PersonsFilter personsFilter);
}
