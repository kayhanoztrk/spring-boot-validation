package com.springbootvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Person is entity class.
 *
 * @author  Kayhan Öztürk
 * @version 0.1
 * @since   0.1
 */
@Entity
@Table(name = "TT_PERSON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name must be not null")
    @Size(min = 3)
    private String name;

    @NotBlank(message = "Surname must be not blank")
    private String surname;

    @Min(value = 18, message = "User can not be younger than 18 age")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

    public Person(@NotNull(message = "Name must be not null") @Size(min = 3) String name,
                  @NotBlank(message = "Surname must be not blank") String surname,
                  @Min(value = 18, message = "User can not be younger than 18 age") int age,
                  @Email(message = "Email should be valid") String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
}
