package com.springtest.demo.dao;

import java.util.List;
import java.util.UUID;
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
}