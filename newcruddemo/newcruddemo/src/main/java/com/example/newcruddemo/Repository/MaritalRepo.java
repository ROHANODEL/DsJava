package com.example.newcruddemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newcruddemo.Model.MaritalStatusEntity;

public interface MaritalRepo extends JpaRepository<MaritalStatusEntity, Integer> {

}
