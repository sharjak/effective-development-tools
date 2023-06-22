package edu.persons.usecase.demo.fibonacci;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
class FetchFibonacciSequenceUseCaseImpl implements FetchFibonacciSequenceUseCase {
    private static final List<BigInteger> FIBONACCI_SEQUENCE = FibonacciUtil.getFibonacciSequence();

    @Override
    public Response execute(Request request) {
        var fibonacciSequenceSubList = FIBONACCI_SEQUENCE.subList(0, request.fibonacciCount());
        return new Response(fibonacciSequenceSubList);
    }
}
