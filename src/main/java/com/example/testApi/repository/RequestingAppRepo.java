package com.example.testApi.repository;

import com.example.testApi.model.RequestingApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestingAppRepo extends JpaRepository<RequestingApp, Long> {

}
