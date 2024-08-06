package br.com.javaspringcurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectsNullException extends RuntimeException {
    private static final long serialVersionUID = 1L; 
    
    public RequiredObjectsNullException() {
        super("It is not allowed to persist a null objetc!");
    }

    public RequiredObjectsNullException(String message) {
        super(message);
    }
}

