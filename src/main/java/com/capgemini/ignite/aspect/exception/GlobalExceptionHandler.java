package com.capgemini.ignite.aspect.exception;

import com.capgemini.ignite.controller.entities.GenericResponse;
import com.capgemini.ignite.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    ResponseEntity<GenericResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(new GenericResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
