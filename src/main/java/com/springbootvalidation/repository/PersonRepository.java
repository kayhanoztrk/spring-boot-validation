package com.springbootvalidation.repository;

import com.springbootvalidation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
