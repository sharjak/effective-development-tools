package org.recipes.usecase.demo.person;

import org.springframework.stereotype.Service;

@Service
class FetchAllPersonsUseCaseImpl implements FetchAllPersonsUseCase {

    @Override
    public Response execute() {
        return new Response(PersonUtil.getPersons());
    }
}
