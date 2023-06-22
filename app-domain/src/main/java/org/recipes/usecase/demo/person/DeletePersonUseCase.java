package org.recipes.usecase.demo.person;

import java.util.UUID;

public interface DeletePersonUseCase {
    void execute(Request request);

    record Request(UUID personId) {}
}
