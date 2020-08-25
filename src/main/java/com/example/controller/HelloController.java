package com.example.controller;

import com.example.model.MyHelloWorld;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class HelloController {

    @Post("/hello")
    public MyHelloWorld hello(@Body MyHelloWorld helloWorld) {
        return helloWorld;
    }
}
