package org.recipes.usecase.demo.fibonacci;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
class FetchFibonacciNthElementUseCaseImpl implements FetchFibonacciNthElementUseCase {
    private static final List<BigInteger> FIBONACCI_SEQUENCE = FibonacciUtil.getFibonacciSequence();

    @Override
    public Response execute(Request request) {
        var nthElementOfFibonacci = FIBONACCI_SEQUENCE.get(request.index());
        return new Response(nthElementOfFibonacci);
    }
}
