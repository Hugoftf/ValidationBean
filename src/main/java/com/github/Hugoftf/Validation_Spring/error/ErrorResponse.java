package com.github.Hugoftf.Validation_Spring.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(int status, String message, List<ErrorFields> errors) {

    public static ErrorResponse standard(String menssage){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), menssage, List.of());
    }
}
