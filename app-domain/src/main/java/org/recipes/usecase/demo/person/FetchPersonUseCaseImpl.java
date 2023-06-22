package org.recipes.usecase.demo.person;

import org.springframework.stereotype.Service;

@Service
class FetchPersonUseCaseImpl implements FetchPersonUseCase {

    @Override
    public Response execute(Request request) {
        var persons = PersonUtil.getPersons();
        var person = persons.stream()
                .filter(p -> p.getId().equals(request.personId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return new Response(person);
    }
}
