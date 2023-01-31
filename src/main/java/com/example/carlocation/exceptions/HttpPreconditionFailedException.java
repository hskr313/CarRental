package com.example.carlocation.exceptions;

import com.example.carlocation.models.dtos.exceptions.HttpExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class HttpPreconditionFailedException extends HttpException{

    private List<FieldError> errors;

    public HttpPreconditionFailedException(String message, List<FieldError> errors) {
        super(message,HttpStatus.PRECONDITION_FAILED);
        this.errors = errors;
    }

    public HttpExceptionDTO getException(){
        return HttpExceptionDTO.builder()
                .message(getMessage())
                .status(HttpStatus.PRECONDITION_FAILED.value())
                .errors(this.errors.stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage)))
                .build();
    }
}
