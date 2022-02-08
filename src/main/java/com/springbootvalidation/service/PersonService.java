package com.springbootvalidation.service;

import com.springbootvalidation.model.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);
    List<Person> findAll();
    Person findById(Long id);
}
