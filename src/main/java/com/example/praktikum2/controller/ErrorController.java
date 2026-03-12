package com.example.praktikum2.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public Map<String,String> handleRuntime(RuntimeException e){

        Map<String,String> error = new HashMap<>();

        error.put("message", e.getMessage());

        return error;
    }

}
