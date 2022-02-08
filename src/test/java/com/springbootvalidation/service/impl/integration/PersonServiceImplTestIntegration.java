package com.springbootvalidation.service.impl.integration;

import com.springbootvalidation.model.Person;
import com.springbootvalidation.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTestIntegration {

    @Autowired
    private PersonService personService;

    @Test
    public void testSave(){
        Person person = new Person();
        person.setId(10L);
        person.setName("testName");
        person.setSurname("testSurname");
        person.setAge(30);
        person.setEmail("test@gmail.com");

        Person person1 = personService.save(person);
        Assert.assertNotNull(person1);
        Assert.assertNotNull(person1);
    }
}
