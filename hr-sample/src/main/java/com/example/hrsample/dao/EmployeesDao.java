package com.example.hrsample.dao;

import com.example.hrsample.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDao extends JpaRepository<Employees, String> {

    Page<Employees>findAllBy(Specification<Employees> specification, Pageable page);
}
