package com.example.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MyCustomException extends JsonProcessingException {
    public MyCustomException(String msg) {
        super(msg);
    }
}
