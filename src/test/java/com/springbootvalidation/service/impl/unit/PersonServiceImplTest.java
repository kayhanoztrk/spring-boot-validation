package com.springbootvalidation.service.impl.unit;

import com.springbootvalidation.model.Person;
import com.springbootvalidation.repository.PersonRepository;
import com.springbootvalidation.service.PersonService;
import com.springbootvalidation.service.impl.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Unit test for {@link PersonServiceImpl}
 *
 * @author  Kayhan Öztürk
 * @version  0.1
 * @since  0.1
 */
public class PersonServiceImplTest {

    private PersonService personService;
    private PersonRepository personRepository;
    private Person person;
    private List<Person> personList;

    @Before
    public void setUp() throws Exception {
        personRepository =  mock(PersonRepository.class);
        personService = new PersonServiceImpl(personRepository);
        person = new Person(3L, "Test", "Test", 19, "test@gmail.com");
        personList = new ArrayList<>();
        personList.add(person);

        when(personRepository.findById(15L)).thenReturn(java.util.Optional.ofNullable(person));
    }

    @Test
    public void testSave(){
        when(personService.save(person)).thenReturn(person);
        Person person1 = personService.save(person);
        Assert.assertNotNull(person1);
    }

    @Test
    public void testFindAll(){
        when(personService.findAll()).thenReturn(personList);
        List<Person> personList1 = personService.findAll();
        Assert.assertNotNull(personList1);
    }

    @Test
    public void testFindById(){
        Person person1 = personService.findById(15L);
        Assert.assertNotNull(person1);
    }
}
