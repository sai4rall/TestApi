package com.example.testApi.service;

import com.example.testApi.model.ClientConfigs;
import com.example.testApi.model.Configs;
import com.example.testApi.model.RequestingApp;
import com.example.testApi.model.TestInput;
import com.example.testApi.repository.ClientConfigsRepo;
import com.example.testApi.repository.RequestingAppRepo;
import com.example.testApi.util.AwsSecretmanagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class TestService {

    @Autowired
    RequestingAppRepo requestingAppRepo;
    @Autowired
    ClientConfigsRepo clientConfigsRepo;

    @Autowired
    AwsSecretmanagerUtil awsSecretmanagerUtil;
    public String addApplication(TestInput testInput) {
        String secret = "{\"Username\":\"" + testInput.getUsername() + "\", \"Password\":\"" + testInput.getPassword() + "\"}";

        if (awsSecretmanagerUtil.createNewSecret(testInput.getRequestingApplicationName(), secret)) {
            //do mysql
            RequestingApp requestingApp=new RequestingApp();
            requestingApp.setRequestingApplicationName(testInput.getRequestingApplicationName());
            requestingApp.setDbCredentionalsConfigured(1);
            requestingApp.setIsActive(testInput.getIsActive());
            requestingApp.setCreatedBy(testInput.getCreatedby());
            requestingAppRepo.save(requestingApp);
            return "App Inserted!";
        }else{
            return "app insertion failed!";

        }
    }



    public Iterable<RequestingApp> getApps(int offset,int pagesize) {
        return requestingAppRepo.findAll(PageRequest.of(offset,pagesize));
    }

    public String deleteApp(long id) {
        try {
            requestingAppRepo.deleteById(id);
            return "deletion sucessful";
        }catch (Exception e){
            return "Exception :"+e.getMessage();
        }
    }

    public String updateApp(long id, TestInput testInput) {
        Optional<RequestingApp> app=requestingAppRepo.findById(id);
        String secret = "{\"Username\":\"" + testInput.getUsername() + "\", \"Password\":\"" + testInput.getPassword() + "\"}";
        if(app.isPresent()){
            if(awsSecretmanagerUtil.updateMySecret(testInput.getRequestingApplicationName(), secret)){
                RequestingApp requestingApp=app.get();
                requestingApp.setRequestingApplicationName(testInput.getRequestingApplicationName());
                requestingApp.setDbCredentionalsConfigured(1);
                requestingApp.setIsActive(testInput.getIsActive());
                requestingApp.setCreatedBy(testInput.getCreatedby());
                requestingAppRepo.save(requestingApp);
                return "Successfully updated!";
            }else {
                return "unable to update secret";
            }

        }else{
            return "app not found!";
        }
    }

    public String addConfigs(Configs testInput) {
       try {
           ClientConfigs clientConfigs = new ClientConfigs();
           clientConfigs.setClientName(testInput.getClientName());
           clientConfigs.setActive(testInput.isActive()?1:0);
           clientConfigs.setClientKafkaCOnnectUrl(testInput.getClientKafkaCOnnectUrl());
           clientConfigs.setClientmskbrokers(testInput.getClientmskbrokers());
           clientConfigs.setCreatedby(testInput.getCreatedby());
           clientConfigsRepo.save(clientConfigs);
           return "saved sucessfully";
       }catch (Exception e){
           e.printStackTrace();
           return "save failed";
       }
    }

    public Iterable<ClientConfigs> getAllConfigs() {
    return clientConfigsRepo.findAll();
    }

    public String deleteConfig(long id) {
        try {
            if(clientConfigsRepo.findById(id).isPresent()) {
                clientConfigsRepo.deleteById(id);
                return "delete Successfull";
            }else{
                return "Invalid Id";
            }
        }catch (Exception e){
            return "delete failed!";
        }
    }

    public String updateConfigs(long id, Configs configs) {
        try {
            Optional<ClientConfigs> configsOptional=clientConfigsRepo.findById(id);
            if(configsOptional.isPresent()) {
                ClientConfigs clientConfigs=configsOptional.get();
                clientConfigs.setClientName(configs.getClientName());
                clientConfigs.setClientmskbrokers(configs.getClientmskbrokers());
                clientConfigs.setCreatedby(configs.getCreatedby());
                clientConfigs.setClientKafkaCOnnectUrl(configs.getClientKafkaCOnnectUrl());
                clientConfigs.setActive(configs.isActive()?1:0);
                return "delete Successfull";
            }else{
                return "Invalid Id";
            }
        }catch (Exception e){
            return "delete failed!";
        }
    }
}
