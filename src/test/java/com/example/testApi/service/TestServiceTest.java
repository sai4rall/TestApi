package com.example.testApi.service;

import com.example.testApi.model.RequestingApp;
import com.example.testApi.model.TestInput;
import com.example.testApi.repository.RequestingAppRepo;
import com.example.testApi.util.AwsSecretmanagerUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {
    @InjectMocks
    TestService testService;

    @Mock
    RequestingAppRepo requestingAppRepo;
    @Mock
    AwsSecretmanagerUtil awsSecretmanagerUtil;
    @Test
    void addApplication() {
        TestInput testInput=new TestInput();
        testInput.setUsername("test");
        testInput.setPassword("test");
        testInput.setRequestingApplicationName("test");

        Mockito.when(awsSecretmanagerUtil.createNewSecret(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        Mockito.when(requestingAppRepo.save(Mockito.any(RequestingApp.class))).thenReturn(new RequestingApp());
        String res=testService.addApplication(testInput);
        assertEquals("App Inserted!",res);
    }

    @Test
    void getApps() {
        RequestingApp app=new RequestingApp();
        Mockito.when(requestingAppRepo.findAll(Mockito.any(PageRequest.class))).thenReturn(new PageImpl(List.of(app)));
        Page<RequestingApp> apps= (Page<RequestingApp>) testService.getApps(1,1);
        assertEquals(1,apps.getSize());
    }

    @Test
    void deleteApp() {
        Mockito.doNothing().when(requestingAppRepo).deleteById(Mockito.any());
        String res=testService.deleteApp(1l);
        assertEquals("deletion sucessful",res);
    }

    @Test
    void updateApp() {
        TestInput testInput=new TestInput();
        testInput.setUsername("test");
        testInput.setPassword("test");
        testInput.setRequestingApplicationName("test");
        RequestingApp app=new RequestingApp();

        Mockito.when(requestingAppRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(app));
        Mockito.when(awsSecretmanagerUtil.updateMySecret(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        Mockito.when(requestingAppRepo.save(Mockito.any(RequestingApp.class))).thenReturn(new RequestingApp());

        String res=testService.updateApp(1l,testInput);
        assertEquals("Successfully updated!",res);


    }

    @Test
    void addConfigs() {
    }

    @Test
    void getAllConfigs() {
    }

    @Test
    void deleteConfig() {
    }

    @Test
    void updateConfigs() {
    }
}