package com.springtest.demo.dao;

import com.springtest.demo.model.Person;
import java.util.List;
import java.util.UUID;

public interface PersonDao {
    
    // method to insert person into database
    int insertPerson(UUID id, Person person);

    // method to insert person into database without a pre-made UUID
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
}