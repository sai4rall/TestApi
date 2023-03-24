package com.example.testApi.util;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretRequest;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;
import software.amazon.awssdk.services.secretsmanager.model.UpdateSecretRequest;
public class AwsSecretmanagerUtil
{


    public  boolean createNewSecret(String secretName, String secretValue) {

        SecretsManagerClient secretsClient = getSecretManagerClient();
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
    public   boolean updateMySecret( String secretName, String secretValue) {
        SecretsManagerClient secretsClient = getSecretManagerClient();

        try {
            UpdateSecretRequest secretRequest = UpdateSecretRequest.builder()
                    .secretId(secretName)
                    .secretString(secretValue)
                    .build();

            secretsClient.updateSecret(secretRequest);
            return true;

        } catch (SecretsManagerException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            return false;

        }
    }
    public static SecretsManagerClient getSecretManagerClient(){

        SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider( ProfileCredentialsProvider.create()) .build();
        return secretsClient;
    }
}
