package com.example.testApi.controller;

import com.example.testApi.model.ClientConfigs;
import com.example.testApi.model.Configs;
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
    @GetMapping(path="/getapps/{offset}/{size}")
    public @ResponseBody Iterable<RequestingApp> getAllUsers(@PathVariable("offset") int offset,@PathVariable("size") int size) {
        // This returns a JSON or XML with the users
        return testService.getApps(offset,size);
    }
    @DeleteMapping("/app/{id}")
    public String deleteapp(@PathVariable("id") int id){
    return testService.deleteApp(id);
    }
    @PutMapping("/app/{id}")
    public String updateApp(@PathVariable("id") int id,@RequestBody @Valid TestInput testInput){
        return testService.updateApp(id,testInput);
    }


    @PostMapping("/configs")
    public String addConfigs(@RequestBody @Valid Configs testInput){
        return testService.addConfigs(testInput);

    }
    @GetMapping("/configs")
    public Iterable<ClientConfigs> getAllCOnfigs(){
        return testService.getAllConfigs();

    }
    @DeleteMapping("/configs/{id}")
    public String getAllCOnfigs(@PathVariable("id") long id){
        return testService.deleteConfig(id);

    }
    @PutMapping("/configs/{id}")
    public String updateConfigs(@PathVariable("id") int id,@RequestBody @Valid Configs testInput){
        return testService.updateConfigs(id,testInput);
    }
}
