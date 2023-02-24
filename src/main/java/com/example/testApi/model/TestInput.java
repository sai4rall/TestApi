package com.example.testApi.model;


import org.hibernate.validator.constraints.NotBlank;

public class TestInput {
    @NotBlank(message = "requesting ApplicationName  cannot be blank")
    private String requestingApplicationName;
    @NotBlank(message = "username  cannot be blank")
    private String username;
    @NotBlank(message = "password  cannot be blank")
    private String password;

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @NotBlank(message = "created  cannot be blank")
    private String createdby;
    @NotBlank(message = "isActive  cannot be blank")
    private int isActive;

    public String getRequestingApplicationName() {
        return requestingApplicationName;
    }

    public void setRequestingApplicationName(String requestingApplicationName) {
        this.requestingApplicationName = requestingApplicationName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
