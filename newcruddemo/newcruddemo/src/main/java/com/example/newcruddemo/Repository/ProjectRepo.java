package com.example.newcruddemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newcruddemo.Model.ProjectEntity;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {

}
