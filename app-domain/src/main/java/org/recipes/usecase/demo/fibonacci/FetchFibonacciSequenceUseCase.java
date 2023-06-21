package org.recipes.usecase.demo.fibonacci;

import java.math.BigInteger;
import java.util.List;

public interface FetchFibonacciSequenceUseCase {
    Response execute(Request request);

    record Request(int fibonacciCount) {}

    record Response(List<BigInteger> fibonacciSequence) {}
}
