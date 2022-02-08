package com.springbootvalidation.model.unit;

import com.springbootvalidation.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

/**
 * Unit test for {@link Person}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
        person.setId(30L);
        person.setName("TestName");
        person.setSurname("TestSurname");
        person.setAge(30);
        person.setEmail("test@gmail.com");
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(person);

        Assert.assertNotNull(person.getId());
        Assert.assertNotNull(person.getAge());
        Assert.assertNotNull(person.getSurname());
        Assert.assertNotNull(person.getEmail());
        Assert.assertNotNull(person.getName());
    }
}
