package com.example.testApi.service;

import com.example.testApi.model.RequestingApp;
import com.example.testApi.model.TestInput;
import com.example.testApi.repository.RequestingAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretRequest;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

@Service
public class TestService {
    @Value("${aws.accessKeyId}")
    String awskeyId;

    @Value("${aws.secret.access.key}")
    String awssecretKey;

    @Autowired
    RequestingAppRepo requestingAppRepo;
    public String addApplication(TestInput testInput) {
        String secret = "{\"Username\":\"" + testInput.getUsername() + "\", \"Password\":\"" + testInput.getPassword() + "\"}";

        if (createNewSecret(testInput.getRequestingApplicationName(), secret)) {
            //do mysql
            RequestingApp requestingApp=new RequestingApp();
            requestingApp.setRequestingApplicationName(testInput.getRequestingApplicationName());
            requestingApp.setDbCredentionalsConfigured(1);
            requestingApp.setIsActive(testInput.getIsActive());
            requestingAppRepo.save(requestingApp);
            return "WOrking";
        }
        return "Not Working";
    }


    private boolean createNewSecret(String secretName, String secretValue) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                awskeyId,
                awssecretKey);
        SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(new AwsCredentialsProvider() {
                    @Override
                    public AwsCredentials resolveCredentials() {
                        return awsCreds;
                    }
                }) .build();
        try {
            CreateSecretRequest secretRequest = CreateSecretRequest.builder()
                    .name(secretName)
                    .description("This secret was created by the AWS Secret Manager Java API")
                    .secretString(secretValue)
                    .build();

            CreateSecretResponse secretResponse = secretsClient.createSecret(secretRequest);
            System.out.println(secretResponse.arn());
            return true;

        } catch (SecretsManagerException e) {
            throw e;
        }
    }


    public Iterable<RequestingApp> getAll() {
        return requestingAppRepo.findAll();
    }

    public String deleteApp(long id) {
        try {
            requestingAppRepo.deleteById(id);
            return "deletion sucessful";
        }catch (Exception e){
            return "Exception :"+e.getMessage();
        }
    }
}
