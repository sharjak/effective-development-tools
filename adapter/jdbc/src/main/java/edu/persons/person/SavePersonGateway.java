package edu.persons.person;

import lombok.RequiredArgsConstructor;
import edu.persons.model.person.Person;
import edu.persons.port.SavePersonPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePersonGateway implements SavePersonPort {
    private final PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        var personRecord = PersonRecord.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();
        personRecord = personRepository.save(personRecord);
        return person.toBuilder().id(personRecord.getId()).build();
    }
}
