package com.example.hrsample.dao;

import com.example.hrsample.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsDao extends JpaRepository<Departments, String> {
}
