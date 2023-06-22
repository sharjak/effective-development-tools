package edu.persons.usecase.demo.fibonacci;

import java.math.BigInteger;

public interface FetchFibonacciNthElementUseCase {
    Response execute(Request request);

    record Request(int index) {}

    record Response(BigInteger nthElementOfFibonacci) {}
}
