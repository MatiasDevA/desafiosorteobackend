package com.example.desafiosorteo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidationArgument(MethodArgumentNotValidException ex){
        Map<String ,String> errorValidation = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error -> {
            errorValidation.put(error.getField(), error.getDefaultMessage());
        });

        return errorValidation;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public Map<String, String> handleEmpleadoException(EmpleadoNotFoundException er){
        Map<String ,String> errorValidation = new HashMap<>();
        errorValidation.put("errorMessage", er.getMessage());
        return errorValidation;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmpleadoAlreadyExistsException.class)
    public Map<String, String> handleEmpleadoCarga(EmpleadoAlreadyExistsException er){
        Map<String, String> errorSave = new HashMap<>();
        errorSave.put("errorMessage", er.getMessage());
        return errorSave;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmpleadoEmailAlreadyExistsException.class)
    public Map<String, String> handleEmpleadoEmail(EmpleadoEmailAlreadyExistsException er){
        Map<String, String> errorSave = new HashMap<>();
        errorSave.put("errorMessage", er.getMessage());
        return errorSave;
    }
}
