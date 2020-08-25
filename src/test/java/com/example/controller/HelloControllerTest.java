package com.example.controller;

import com.example.model.MyHelloWorld;
import com.example.response.MyResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class HelloControllerTest {

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    public void shouldGetHelloMessage() {
        String jsonBody = "{" +
                "\"message\": \"Hello message\"" +
                "}";

        try {
            client.toBlocking().exchange(HttpRequest.POST("/hello", jsonBody), Argument.of(MyHelloWorld.class), Argument.of(MyResponse.class));
        } catch (HttpClientResponseException e) {
            Assertions.assertEquals(HttpStatus.BAD_REQUEST, e.getStatus());
            MyResponse body = e.getResponse().getBody(MyResponse.class).get();
            Assertions.assertEquals("fail", body.getMessage().getStatus());
            Assertions.assertEquals("desc", body.getMessage().getDescription());
        }
    }
}
