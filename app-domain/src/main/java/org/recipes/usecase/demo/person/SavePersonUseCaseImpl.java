package org.recipes.usecase.demo.person;

import lombok.RequiredArgsConstructor;
import org.recipes.port.SavePersonPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SavePersonUseCaseImpl implements SavePersonUseCase {
    private final SavePersonPort savePersonPort;

    @Override
    public Response execute(Request request) {
        var personWithId = savePersonPort.save(request.person());
        return new Response(personWithId);
    }
}
