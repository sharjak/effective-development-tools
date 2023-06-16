package org.recipes.demo;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.Stream;

@Service
class DemoUseCaseImpl implements DemoUseCase {

    @Override
    public Response execute(Request request) {
        var fibonacciSequence =
                Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, t -> new BigInteger[]{t[1], t[0].add(t[1])})
                        .limit(request.fibonacciCount())
                        .map(t -> t[0])
                        .toList();
        return new Response(fibonacciSequence);
    }
}
