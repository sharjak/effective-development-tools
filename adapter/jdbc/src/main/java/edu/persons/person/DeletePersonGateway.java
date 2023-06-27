package edu.persons.person;

import edu.persons.port.DeletePersonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class DeletePersonGateway implements DeletePersonPort {
    private final PersonRepository personRepository;

    @Override
    public void delete(UUID personId) {
        personRepository.deleteById(personId);
    }
}
