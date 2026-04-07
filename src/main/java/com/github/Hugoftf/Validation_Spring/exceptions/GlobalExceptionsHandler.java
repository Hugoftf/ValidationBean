package com.github.Hugoftf.Validation_Spring.exceptions;

import com.github.Hugoftf.Validation_Spring.error.ErrorFields;
import com.github.Hugoftf.Validation_Spring.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldsList = e.getFieldErrors();
        List<ErrorFields> errorFields = fieldsList.stream().map(
                fieldError -> new ErrorFields(fieldError.getField(),

                fieldError.getDefaultMessage())).collect(Collectors.toList());


        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error Validation", errorFields);
    }
}
