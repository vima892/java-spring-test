package com.springtest.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.io.Console;
import java.util.ArrayList;
import com.springtest.demo.model.Person;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personMaybe = selectPersonByID(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        return selectPersonByID(id).map(p -> {              // select the person
            int indexOfPersonToUpdate = DB.indexOf(p); // map the person
            if (indexOfPersonToUpdate >= 0) {               // if that person exists
                DB.set(indexOfPersonToUpdate, person);      // update content of person
                return 1;
            } return 0;
        }).orElse(0);
    }
}