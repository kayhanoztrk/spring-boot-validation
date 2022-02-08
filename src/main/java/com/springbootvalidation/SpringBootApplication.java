package com.springbootvalidation;

import com.springbootvalidation.model.Person;
import com.springbootvalidation.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    public SpringBootApplication(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
            personRepository.save(new Person("James", "Hetfield", 29, "test@gmail.com"));
            personRepository.save(new Person("Kirk", "Hammett", 35, "test@gmail.com"));
    }
}
