package org.recipes.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {
    private final DemoUseCase demoUseCase;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world!");
    }

    @GetMapping("/fibonacci")
    public ResponseEntity<List<BigInteger>> fibonacci(@RequestParam Integer fibonacciCount) {
        var request = new DemoUseCase.Request(fibonacciCount);
        var response =  demoUseCase.execute(request);
        return ResponseEntity.ok(response.fibonacciSequence());
    }
}