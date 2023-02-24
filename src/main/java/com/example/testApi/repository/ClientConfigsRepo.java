package com.example.testApi.repository;

import com.example.testApi.model.ClientConfigs;
import org.springframework.data.repository.CrudRepository;

public interface ClientConfigsRepo extends CrudRepository<ClientConfigs,Long> {
}
