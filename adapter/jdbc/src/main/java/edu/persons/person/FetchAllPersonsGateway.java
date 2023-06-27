package edu.persons.person;

import edu.persons.model.person.Person;
import edu.persons.model.person.PersonsFilter;
import edu.persons.port.FetchAllPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class FetchAllPersonsGateway implements FetchAllPersonsPort {
    private final PersonRepository personRepository;

    @Override
    public List<Person> fetchAllPersons(PersonsFilter personsFilter) {
        var persons = personRepository.findByFilter(personsFilter);
        return persons.stream()
                .map(pr -> Person.builder()
                        .id(pr.getId())
                        .firstName(pr.getFirstName())
                        .lastName(pr.getLastName())
                        .build())
                .toList();
    }
}
