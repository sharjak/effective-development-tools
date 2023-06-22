package org.recipes.usecase.demo.person;

import org.recipes.model.person.Person;

import java.util.List;

public interface FetchAllPersonsUseCase {
    Response execute();

    record Response(List<Person> persons) {}
}
