package org.recipes.port;

import org.recipes.model.person.Person;

public interface SavePersonPort {

    Person save(Person person);
}
