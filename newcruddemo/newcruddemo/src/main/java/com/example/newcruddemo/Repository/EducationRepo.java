package com.example.newcruddemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newcruddemo.Model.EducationEntity;

public interface EducationRepo extends JpaRepository<EducationEntity, Integer> {

}
