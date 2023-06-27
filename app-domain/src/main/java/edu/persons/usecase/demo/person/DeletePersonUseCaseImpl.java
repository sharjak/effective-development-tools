package edu.persons.usecase.demo.person;

import edu.persons.port.DeletePersonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DeletePersonUseCaseImpl implements DeletePersonUseCase {
    private final DeletePersonPort deletePersonPort;

    @Override
    public void execute(Request request) {
        //Solution with PersonUtil
        //var persons = PersonUtil.getPersons();
        //persons.removeIf(person -> person.getId().equals(request.personId()));
        deletePersonPort.delete(request.personId());
    }
}
