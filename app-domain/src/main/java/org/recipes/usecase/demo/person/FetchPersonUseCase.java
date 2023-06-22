package org.recipes.usecase.demo.person;

import org.recipes.model.person.Person;

import java.util.UUID;

public interface FetchPersonUseCase {
    Response execute(Request request);

    record Request(UUID personId) {}

    record Response(Person person) {}
}
