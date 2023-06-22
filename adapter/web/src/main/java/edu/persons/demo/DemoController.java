package edu.persons.demo;

import edu.persons.usecase.demo.fibonacci.FetchFibonacciNthElementUseCase;
import edu.persons.usecase.demo.fibonacci.FetchFibonacciSequenceUseCase;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {
    private final FetchFibonacciSequenceUseCase fetchFibonacciSequenceUseCase;
    private final FetchFibonacciNthElementUseCase fetchFibonacciNthElementUseCase;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world!");
    }

    @GetMapping("/fibonacci")
    public ResponseEntity<List<BigInteger>> fetchFibonacciSequence(@RequestParam @Min(0) @Max(100) Integer fibonacciCount) {
        var request = new FetchFibonacciSequenceUseCase.Request(fibonacciCount);
        var response =  fetchFibonacciSequenceUseCase.execute(request);
        return ResponseEntity.ok(response.fibonacciSequence());
    }

    @GetMapping("/fibonacci/{index}")
    public ResponseEntity<BigInteger> fetchFibonacciNthElement(@PathVariable @Min(0) @Max(99) Integer index) {
        var request = new FetchFibonacciNthElementUseCase.Request(index);
        var response = fetchFibonacciNthElementUseCase.execute(request);
        return ResponseEntity.ok(response.nthElementOfFibonacci());
    }
}