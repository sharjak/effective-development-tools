package org.recipes.demo;

import java.math.BigInteger;
import java.util.List;

public interface DemoUseCase {
    Response execute(Request request);

    record Request(Integer fibonacciCount) {}

    record Response(List<BigInteger> fibonacciSequence) {}
}
