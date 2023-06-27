package edu.persons.usecase.demo.person;

import edu.persons.model.person.Person;
import edu.persons.model.person.PersonsFilter;
import edu.persons.port.FetchAllPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FetchAllPersonsUseCaseImpl implements FetchAllPersonsUseCase {
    private final FetchAllPersonsPort fetchAllPersonsPort;

    @Override
    public Response execute(Request request) {
        //PersonUtil solution
//        var filter = request.filter();
//        var persons = PersonUtil.getPersons().stream()
//                .filter(person -> personNameMatches(person, filter))
//                .toList();
//        return new Response(persons);
        return new Response(fetchAllPersonsPort.fetchAllPersons(request.filter()));
    }

    private boolean personNameMatches(Person person, PersonsFilter personsFilter) {
        if (personsFilter.getFirstName() == null && personsFilter.getLastName() == null) {
            return true;
        } else if (personsFilter.getFirstName() != null
                && lowerCaseStringDoesNotMatch(person.getFirstName(), personsFilter.getFirstName())) {
            return false;
        } else if (personsFilter.getLastName() != null
                && lowerCaseStringDoesNotMatch(person.getLastName(), personsFilter.getLastName())) {
            return false;
        }
        return true;
    }

    private boolean lowerCaseStringDoesNotMatch(String personValue, String filterValue) {
        return !personValue.toLowerCase().contains(filterValue.toLowerCase());
    }
}
