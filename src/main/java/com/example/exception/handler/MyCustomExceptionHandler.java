package com.example.exception.handler;

import com.example.exception.MyCustomException;
import com.example.response.Data;
import com.example.response.MyResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Singleton
public class MyCustomExceptionHandler implements ExceptionHandler<MyCustomException, HttpResponse<MyResponse>> {

    @Override
    public HttpResponse<MyResponse> handle(HttpRequest request, MyCustomException exception) {
        Data data = new Data();
        data.setDescription("desc");
        data.setStatus("fail");
        MyResponse myResponse = new MyResponse();
        myResponse.setMessage(data);
        return HttpResponse.badRequest(myResponse);
    }
}
