package com.springbootvalidation.controller;

import com.springbootvalidation.model.Person;
import com.springbootvalidation.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * PersonRestController expose our data to client side.
 *
 * @author Kayhan Öztürk
 * @version  0.1
 * @since 0.1
 */
@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {
        Person person1 = personService.save(person);
        return ResponseEntity.ok(person1);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> personList = personService.findAll();
        return ResponseEntity.ok(personList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

}
