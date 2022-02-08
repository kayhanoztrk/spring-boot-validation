package com.springbootvalidation.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootvalidation.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.springbootvalidation.controller.PersonController;

/**
 * Integration test for {@link PersonController}
 *
 * @author Kayhan Öztürk
 * @version  0.1
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTestIntegration {
    private static final String PERSON_CONTROLLER_ROOT = "/api/v1/person";
    private static final String PERSON_CREATE_URL = PERSON_CONTROLLER_ROOT;
    private static final String PERSON_FIND_ALL = PERSON_CONTROLLER_ROOT + "/list";
    private static final String PERSON_FIND_BY_ID = PERSON_CONTROLLER_ROOT + "/find/{id}";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Person person;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //initializing person param.
        person = new Person();
        person.setName("testName");
        person.setSurname("testSurname");
        person.setAge(30);
        person.setEmail("testEmail@gmail.com");
    }

    @Test
    public void testCreatePerson() throws Exception {

        mockMvc.perform(post(PERSON_CREATE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(person)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {

        mockMvc.perform(get(PERSON_FIND_ALL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {

        mockMvc.perform(get(PERSON_FIND_BY_ID, 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
