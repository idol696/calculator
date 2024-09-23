package ru.prostostudia.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("Делить на ноль нельзя!");
    }
}
