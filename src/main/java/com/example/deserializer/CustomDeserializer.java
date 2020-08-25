package com.example.deserializer;

import com.example.exception.MyCustomException;
import com.example.model.MyHelloWorld;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import javax.inject.Singleton;

@Singleton
public class CustomDeserializer extends JsonDeserializer<MyHelloWorld> {
    @Override
    public MyHelloWorld deserialize(JsonParser p, DeserializationContext ctxt) throws JsonProcessingException {
        // Some code to deserialize json
        return getObject();
    }

    private MyHelloWorld getObject() throws MyCustomException {
        throw new MyCustomException("Error while parsing json");
    }
}
