package edu.persons.person;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
record PersonDto(UUID id,
                 @NotBlank String firstName,
                 @NotBlank String lastName) {
}
