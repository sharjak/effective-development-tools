package org.recipes.person;

import lombok.RequiredArgsConstructor;
import org.recipes.model.person.Person;
import org.recipes.port.SavePersonPort;
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
