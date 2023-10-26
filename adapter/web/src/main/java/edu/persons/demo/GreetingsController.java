package edu.persons.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/demo/greetings")
public class GreetingsController {
    private static final String DEFAULT_GREETING = "Hello world!";
    private static final Map<Integer, String> GREETINGS_MAP = new HashMap<>(Map.of(1, "Greetings, Universe!",
            2, "Welcome, New Beginnings!",
            3, "Ahoy, Adventurers!"));

    @GetMapping
    public ResponseEntity<String> fetchGreeting() {
        return ResponseEntity.ok(DEFAULT_GREETING);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> fetchGreeting(@PathVariable Integer id) {
        return ResponseEntity.ok(GREETINGS_MAP.getOrDefault(id, DEFAULT_GREETING));
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<String>> fetchAllGreetings(String query) {
        var greetings = GREETINGS_MAP.values();
        if (query != null) {
            greetings = greetings.stream()
                    .filter(greeting -> greeting.contains(query))
                    .toList();

        }
        return ResponseEntity.ok(greetings);
    }

    @PostMapping
    public ResponseEntity<String> addGreeting(@Valid @RequestBody GreetingDto greetingDto) {
        var existingGreeting = GREETINGS_MAP.get(greetingDto.id);
        if (existingGreeting != null) {
            return ResponseEntity.badRequest().body("Id already exists: " + greetingDto.id);
        }
        GREETINGS_MAP.put(greetingDto.id, greetingDto.greeting);
        return ResponseEntity.ok().build();
    }

    record GreetingDto(@NotNull Integer id,
                       @NotBlank String greeting) {
    }

}
