package com.example.testApi.service;

import com.example.testApi.model.TestInput;
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
    public String addApplication(TestInput testInput) {
        String secret = "{\"Username\":\"" + testInput.getUsername() + "\", \"Password\":\"" + testInput.getPassword() + "\"}";

        if (createNewSecret(testInput.getRequestingApplicationName(), secret)) {
            //do mysql
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


}
