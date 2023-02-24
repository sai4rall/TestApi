package com.example.testApi.model;

import javax.validation.constraints.NotBlank;

public class Configs {
    @NotBlank(message = "client name can not be blank")
    private String clientName;
    @NotBlank(message = "clientMsk brokers can not be blank")

    private String clientmskbrokers;

    @NotBlank(message = "clientKafkaConnectUrl can not be blank")

    private String clientKafkaCOnnectUrl;
    @NotBlank(message = "created bycan not be blank")

    private String createdby;
    @NotBlank(message = "isActive can not be blank")

    private boolean isActive;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientmskbrokers() {
        return clientmskbrokers;
    }

    public void setClientmskbrokers(String clientmskbrokers) {
        this.clientmskbrokers = clientmskbrokers;
    }

    public String getClientKafkaCOnnectUrl() {
        return clientKafkaCOnnectUrl;
    }

    public void setClientKafkaCOnnectUrl(String clientKafkaCOnnectUrl) {
        this.clientKafkaCOnnectUrl = clientKafkaCOnnectUrl;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
