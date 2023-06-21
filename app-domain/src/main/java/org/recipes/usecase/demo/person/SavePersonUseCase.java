package org.recipes.usecase.demo.person;

import org.recipes.model.person.Person;

public interface SavePersonUseCase {
    Response execute(Request request);

    record Request(Person person) {}

    record Response(Person person) {}
}
