package edu.persons.demo.fibonacci;

import edu.persons.usecase.demo.fibonacci.FetchFibonacciNthElementUseCase;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import edu.persons.usecase.demo.fibonacci.FetchFibonacciSequenceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/fibonacci")
public class FibonacciController {
    private final FetchFibonacciSequenceUseCase fetchFibonacciSequenceUseCase;
    private final FetchFibonacciNthElementUseCase fetchFibonacciNthElementUseCase;

    @GetMapping()
    public ResponseEntity<List<BigInteger>> fetchFibonacciSequence(@RequestParam @Min(0) @Max(100) Integer fibonacciCount) {
        var request = new FetchFibonacciSequenceUseCase.Request(fibonacciCount);
        var response =  fetchFibonacciSequenceUseCase.execute(request);
        return ResponseEntity.ok(response.fibonacciSequence());
    }

    @GetMapping("{index}")
    public ResponseEntity<BigInteger> fetchFibonacciNthElement(@PathVariable @Min(0) @Max(99) Integer index) {
        var request = new FetchFibonacciNthElementUseCase.Request(index);
        var response = fetchFibonacciNthElementUseCase.execute(request);
        return ResponseEntity.ok(response.nthElementOfFibonacci());
    }
}