package edu.persons.person;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

record PersonDto(UUID id,
                 @NotBlank String firstName,
                 @NotBlank String lastName) {
}
