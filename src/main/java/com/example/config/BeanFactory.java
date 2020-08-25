package com.example.config;

import com.example.deserializer.CustomDeserializer;
import com.example.model.MyHelloWorld;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class BeanFactory {

    @Singleton
    public Module deserializer() {
        return new SimpleModule().addDeserializer(MyHelloWorld.class, new CustomDeserializer());
    }
}
