package com.example.testApi.controller;

import com.example.testApi.model.RequestingApp;
import com.example.testApi.model.TestInput;
import com.example.testApi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @PostMapping("/add")
    public String test(@RequestBody @Valid TestInput testInput){
        return testService.addApplication(testInput);

    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<RequestingApp> getAllUsers() {
        // This returns a JSON or XML with the users
        return testService.getAll();
    }
    @DeleteMapping("/app/{id}")
    public String deleteapp(@PathVariable("id") int id){
    return testService.deleteApp(id);
    }
}
