package edu.persons.person;

import edu.persons.model.person.Person;
import edu.persons.port.FetchPersonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class FetchPersonGateway implements FetchPersonPort {
    private final PersonRepository personRepository;

    @Override
    public Person fetch(UUID personId) {
        var personEntity = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person was not found"));
        return Person.builder()
                .id(personEntity.getId())
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .build();
    }
}
