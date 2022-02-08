package com.springbootvalidation.service.impl;

import com.springbootvalidation.exception.PersonNotFoundException;
import com.springbootvalidation.model.Person;
import com.springbootvalidation.repository.PersonRepository;
import com.springbootvalidation.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  PersonServiceImpl is implementation of {@link PersonService}
 *
 * @author Kayhan Öztürk
 * @version  0.1
 * @since    0.1
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("User not found by id : " + id));
    }
}
