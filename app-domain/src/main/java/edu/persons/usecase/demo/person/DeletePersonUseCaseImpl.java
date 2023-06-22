package edu.persons.usecase.demo.person;

import org.springframework.stereotype.Service;

@Service
class DeletePersonUseCaseImpl implements DeletePersonUseCase {

    @Override
    public void execute(Request request) {
        var persons = PersonUtil.getPersons();
        persons.removeIf(person -> person.getId().equals(request.personId()));
    }
}
