package edu.persons.model.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PersonsFilter {
    private String firstName;
    private String lastName;
}
