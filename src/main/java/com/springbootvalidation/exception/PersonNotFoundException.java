package com.springbootvalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * PersonNotFoundException is CustomException class.
 *
 * @author  Kayhan Öztürk
 * @version  0.1
 * @since   0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String message) {
        super(message);
    }
}
