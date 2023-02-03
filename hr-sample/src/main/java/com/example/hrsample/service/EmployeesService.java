package com.example.hrsample.service;

import com.example.hrsample.dao.EmployeesDao;
import com.example.hrsample.entity.Departments;
import com.example.hrsample.entity.Employees;
import com.example.hrsample.util.HelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class EmployeesService {
    @Autowired
    private EmployeesDao employeesDao;

    public Page<Employees>getFilterByNameOrDepartmentsAndPage(String firstName, String lastName, Departments departments, Pageable page) {
        Page<Employees> employeesPage = employeesDao.findAllBy(getSpecificationByNameOrDepartments(firstName, lastName, departments), page);

        return employeesPage;
    }

    public Page<Employees>getAllAndPage(Pageable page) {
        return employeesDao.findAll(page);
    }

    private Specification<Employees>getSpecificationByNameOrDepartments(String firstName, String lastName, Departments departments) {
        return (((root, query, builder) -> {
            //log.info("First Name:{}, Last Name:{}, Departments:{}", firstName, lastName, departments);
            List<Predicate> predicates = new ArrayList<>();

            if(firstName != null || !firstName.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("first_name")), HelperUtil.getContainsLikePattern(firstName)));
            }
            if(lastName != null || !lastName.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("last_name")), HelperUtil.getContainsLikePattern(lastName)));
            }
            if(departments != null) {
                predicates.add(builder.equal(root.get("departments"), departments));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
