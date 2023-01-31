package com.example.carlocation.models.dtos.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class HttpExceptionDTO {

    private String message;

    private int status;

    private Map<String, String> errors;

}
