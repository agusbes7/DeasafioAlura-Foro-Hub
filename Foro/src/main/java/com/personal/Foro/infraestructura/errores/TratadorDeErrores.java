
package com.personal.Foro.infraestructura.errores;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorDeErrores {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity   tratarError404(EntityNotFoundException e)
    { var body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity tratarErrorResponseStatus(ResponseStatusException e) {
        var body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", e.getStatusCode().value());
        body.put("error", e.getStatusCode());
        body.put("message", e.getReason());
        return new ResponseEntity<>(body, e.getStatusCode());
    }
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity  tratarErrorFormatoInvalido(InvalidFormatException e) {
        var body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);}

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
