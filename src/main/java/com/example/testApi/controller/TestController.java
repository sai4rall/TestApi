package com.example.testApi.controller;

import com.example.testApi.model.TestInput;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/add")
    public String test(@RequestBody @Valid TestInput testInput){
        return "Hello";
    }
    @DeleteMapping("/app")
    public String deleteapp(@RequestBody @Valid TestInput testInput){
        return "Hello";
    }
}
