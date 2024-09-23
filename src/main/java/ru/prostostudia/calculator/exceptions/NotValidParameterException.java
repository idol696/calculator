package ru.prostostudia.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidParameterException extends IllegalArgumentException {

    public NotValidParameterException() {
        super("Неправильный или неполный параметр!");
    }
}
