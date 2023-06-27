package edu.persons.person;

import edu.persons.model.person.PersonsFilter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<PersonRecord, UUID> {

    @Query("SELECT p FROM PersonRecord p " +
            "       WHERE (:#{#filter.firstName} IS NULL " +
            "              OR (:#{#filter.firstName} IS NOT NULL" +
            "                  AND p.firstName ilike %:#{#filter.firstName}%))" +
            "         AND (:#{#filter.lastName} IS NULL" +
            "              OR (:#{#filter.lastName} IS NOT NULL" +
            "                  AND p.lastName ilike %:#{#filter.lastName}%))")
    List<PersonRecord> findByFilter(@Param("filter") PersonsFilter personsFilter);
}
