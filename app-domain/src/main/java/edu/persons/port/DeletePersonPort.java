package edu.persons.port;

import java.util.UUID;

public interface DeletePersonPort {

    void delete(UUID personId);
}
