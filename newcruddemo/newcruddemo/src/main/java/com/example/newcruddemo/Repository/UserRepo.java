package com.example.newcruddemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newcruddemo.Model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
