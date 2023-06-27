package edu.persons.person;

import edu.persons.model.person.Person;
import edu.persons.model.person.PersonsFilter;
import edu.persons.usecase.demo.person.DeletePersonUseCase;
import edu.persons.usecase.demo.person.FetchAllPersonsUseCase;
import edu.persons.usecase.demo.person.FetchPersonUseCase;
import edu.persons.usecase.demo.person.SavePersonUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonsController {
    private final FetchAllPersonsUseCase fetchAllPersonsUseCase;
    private final FetchPersonUseCase fetchPersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;
    private final SavePersonUseCase savePersonUseCase;

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons(PersonsFilterDto filterDto) {
        var request = new FetchAllPersonsUseCase.Request(toDomain(filterDto));
        var persons = fetchAllPersonsUseCase.execute(request).persons();
        var dtos = persons.stream()
                .map(this::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping({"{personId}"})
    public ResponseEntity<PersonDto> fetch(@PathVariable UUID personId) {
        var request = new FetchPersonUseCase.Request(personId);
        var response = fetchPersonUseCase.execute(request);
        var dto = toDto(response.person());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{personId}")
    public ResponseEntity<Void> delete(@PathVariable UUID personId) {
        var request = new DeletePersonUseCase.Request(personId);
        deletePersonUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto personDto) {
        var person = toDomain(personDto);
        var request = new SavePersonUseCase.Request(person);
        var response = savePersonUseCase.execute(request);
        return ResponseEntity.ok(toDto(response.person()));
    }

    private Person toDomain(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.firstName())
                .lastName(personDto.lastName())
                .build();
    }

    private PersonDto toDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();
    }

    private PersonsFilter toDomain(PersonsFilterDto dto) {
        return PersonsFilter.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build();
    }
}
