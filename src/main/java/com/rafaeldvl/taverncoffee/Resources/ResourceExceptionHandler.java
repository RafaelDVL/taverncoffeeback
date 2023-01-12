package com.rafaeldvl.taverncoffee.Resources;

import com.rafaeldvl.taverncoffee.Services.Exceptions.DataIntegrityViolationException;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest httpServletRequest){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),"Objeto não encontrado!!", exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest httpServletRequest){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),"Conflito de dados!!", exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
