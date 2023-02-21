package com.example.testApi.controller;

import com.example.testApi.model.TestInput;
import com.example.testApi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @PostMapping("/add")
    public String test(@RequestBody @Valid TestInput testInput){
        return testService.addApplication(testInput);

    }
    @DeleteMapping("/app")
    public String deleteapp(@RequestBody @Valid TestInput testInput){
        return "Hello";
    }
}
