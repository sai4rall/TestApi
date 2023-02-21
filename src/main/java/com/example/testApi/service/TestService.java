/*
package com.example.testApi.service;

import com.example.testApi.model.TestInput;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String addApplication(TestInput testInput){
        if(postSecret(testInput.getUsername(),testInput.getPassword()));
        return
    }

    private boolean postSecret(String username, String password) {

    }
    public static String createNewSecret( SecretsManagerClient secretsClient, String secretName, String secretValue) {

        try {
            CreateSecretRequest secretRequest = CreateSecretRequest.builder()
                    .name(secretName)
                    .description("This secret was created by the AWS Secret Manager Java API")
                    .secretString(secretValue)
                    .build();

            CreateSecretResponse secretResponse = secretsClient.createSecret(secretRequest);
            return secretResponse.arn();

        } catch (SecretsManagerException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }


}
*/
