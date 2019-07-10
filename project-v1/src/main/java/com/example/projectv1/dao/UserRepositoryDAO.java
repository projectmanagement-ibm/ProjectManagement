package com.example.projectv1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.entitty.User;

public interface UserRepositoryDAO extends JpaRepository<User, Integer> {

}
