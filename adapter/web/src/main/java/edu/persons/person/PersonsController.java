package edu.persons.person;

import edu.persons.model.person.Person;
import edu.persons.usecase.demo.person.DeletePersonUseCase;
import edu.persons.usecase.demo.person.FetchAllPersonsUseCase;
import edu.persons.usecase.demo.person.FetchPersonUseCase;
import edu.persons.usecase.demo.person.SavePersonUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonsController {
    private final FetchAllPersonsUseCase fetchAllPersonsUseCase;
    private final FetchPersonUseCase fetchPersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;
    private final SavePersonUseCase savePersonUseCase;

    @GetMapping
    public ResponseEntity<List<PersonDto>> fetchAll() {
        var response = fetchAllPersonsUseCase.execute();
        var dtos = response.persons().stream().map(this::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{personId}")
    public ResponseEntity<PersonDto> fetch(@PathVariable UUID personId) {
        var request = new FetchPersonUseCase.Request(personId);
        var response = fetchPersonUseCase.execute(request);
        return ResponseEntity.ok(toDto(response.person()));
    }

    @DeleteMapping("{personId}")
    public ResponseEntity<Void> delete(@PathVariable UUID personId) {
        var request = new DeletePersonUseCase.Request(personId);
        deletePersonUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto personDto) {
        var request = new SavePersonUseCase.Request(toDomain(personDto));
        savePersonUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

    private PersonDto toDto(Person person) {
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName());
    }

    private Person toDomain(PersonDto dto) {
        return Person.builder()
                .id(dto.id())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build();
    }
}
