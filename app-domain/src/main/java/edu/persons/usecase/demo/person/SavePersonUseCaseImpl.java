package edu.persons.usecase.demo.person;

import lombok.RequiredArgsConstructor;
import edu.persons.port.SavePersonPort;
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
