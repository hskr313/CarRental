package com.example.carlocation.exceptions;

import com.example.carlocation.models.dtos.exceptions.HttpExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class HttpException extends RuntimeException {

    private HttpExceptionDTO exception;

    public HttpException(String message, HttpStatus status){
        super(message);

        exception = HttpExceptionDTO.builder()
                .status(status.value())
                .message(message)
                .build();
    }
}
