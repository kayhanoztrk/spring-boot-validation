package com.springbootvalidation.controller.unit;

import com.springbootvalidation.controller.PersonController;
import com.springbootvalidation.model.Person;
import com.springbootvalidation.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link PersonController}
 *
 * @author  Kayhan Öztürk
 * @version  0.1
 * @since 0.1
 */
public class PersonControllerTest {

    private PersonController personController;
    private PersonService personService;
    private Person person;

    @Before
    public void setUp(){
        personService = mock(PersonService.class);
        personController = new PersonController(personService);

        person = new Person();
        person.setId(2L);
        person.setName("testName");
        person.setSurname("testSurName");
        person.setAge(30);
        person.setEmail("test@gmail.com");

        when(personService.save(person)).thenReturn(person);
        when(personService.findById(1L)).thenReturn(person);
    }

    @Test
    public void testCreatePerson(){
        ResponseEntity<Person> personResponseEntity = personController.createPerson(person);
        Assert.assertNotNull(personResponseEntity);
    }

    @Test
    public void testFindAll(){
        ResponseEntity<List<Person>> response = personController.findAll();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testFindById(){
        ResponseEntity<Person> response = personController.findById(1L);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(response.getStatusCode());
    }
}
