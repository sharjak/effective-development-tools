package org.recipes.usecase.demo.person;

import lombok.experimental.UtilityClass;
import org.recipes.model.person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@UtilityClass
class PersonUtil {
    private final List<Person> persons = new ArrayList<>(Arrays.asList(
            Person.builder()
                    .id(UUID.fromString("d85dcfca-b940-48c5-b040-80cc24fea897"))
                    .firstName("Jon")
                    .lastName("Snow")
                    .build(),
            Person.builder()
                    .id(UUID.fromString("4a51f1eb-5ef3-4ed4-a7ec-68a027b14c40"))
                    .firstName("Bruce")
                    .lastName("Wayne")
                    .build(),
            Person.builder()
                    .id(UUID.fromString("ce3a3e2c-84af-4b99-867e-13c628af081b"))
                    .firstName("Jack")
                    .lastName("Napier")
                    .build(),
            Person.builder()
                    .id(UUID.fromString("ec059df0-fb60-46b1-9585-2b3a56a25dc7"))
                    .firstName("Tony")
                    .lastName("Stark")
                    .build(),
            Person.builder()
                    .id(UUID.fromString("060c5055-92e4-49a7-82e3-c1f9ec89129a"))
                    .firstName("Clark")
                    .lastName("Kent")
                    .build()
    ));

    public static List<Person> getPersons() {
        return persons;
    }
}
