package com.springtest.demo.service;

import com.springtest.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springtest.demo.dao.PersonDao;

@Service
public class PersonService {

    private final PersonDao personDao; 

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonByID(UUID id) {
        return personDao.selectPersonByID(id);
    }

    public int deletePersonById(UUID id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePersonById(UUID id, Person newPerson) {
        return personDao.updatePersonByID(id, newPerson);
    }

}