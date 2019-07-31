package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SubTask;

public interface SubTaskRepo  extends JpaRepository<SubTask, Integer>{

}
