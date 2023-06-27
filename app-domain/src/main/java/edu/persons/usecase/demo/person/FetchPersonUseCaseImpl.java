package edu.persons.usecase.demo.person;

import edu.persons.port.FetchPersonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FetchPersonUseCaseImpl implements FetchPersonUseCase {
    private final FetchPersonPort fetchPersonPort;

    @Override
    public Response execute(Request request) {
//        var persons = PersonUtil.getPersons();
//        var person = persons.stream()
//                .filter(p -> p.getId().equals(request.personId()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Person not found"));
//        return new Response(person);
        var person = fetchPersonPort.fetch(request.personId());
        return new Response(person);
    }
}
