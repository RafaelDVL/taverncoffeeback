package com.rafaeldvl.taverncoffee.Resources;

import com.rafaeldvl.taverncoffee.Services.Exceptions.DataIntegrityViolationException;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ObjectNotFoundException;
import com.rafaeldvl.taverncoffee.Services.Exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException exception, HttpServletRequest httpServletRequest){
        ValidationError errors = new ValidationError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Erro ao validar os campos!", exception.getMessage(), httpServletRequest.getRequestURI());
        for(FieldError o : exception.getBindingResult().getFieldErrors()){
            errors.addListaErrors(o.getField(),o.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}
