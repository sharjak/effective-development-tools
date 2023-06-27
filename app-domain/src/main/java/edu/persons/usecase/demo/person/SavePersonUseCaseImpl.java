package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;
import lombok.RequiredArgsConstructor;
import edu.persons.port.SavePersonPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class SavePersonUseCaseImpl implements SavePersonUseCase {
    private final SavePersonPort savePersonPort;

    @Override
    public Response execute(Request request) {
        //PersonUtil solution
//        var person = request.person().toBuilder().id(UUID.randomUUID()).build();
//        var persons = PersonUtil.getPersons();
//        persons.add(person);
//        return new Response(person);

        var personWithId = savePersonPort.save(request.person());
        return new Response(personWithId);
    }
}
