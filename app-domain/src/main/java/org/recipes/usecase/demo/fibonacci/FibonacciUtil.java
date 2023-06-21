package org.recipes.usecase.demo.fibonacci;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

@UtilityClass
class FibonacciUtil {
    private static final List<BigInteger> FIBONACCI_SEQUENCE =
            Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, t -> new BigInteger[]{t[1], t[0].add(t[1])})
                    .limit(100)
                    .map(t -> t[0])
                    .toList();

    public static List<BigInteger> getFibonacciSequence() {
        return List.copyOf(FIBONACCI_SEQUENCE);
    }
}
