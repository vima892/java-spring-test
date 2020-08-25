package com.springtest.demo.service;

import com.springtest.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}