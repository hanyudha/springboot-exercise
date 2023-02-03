package com.example.hrsample.controller;

import com.example.hrsample.entity.Departments;
import com.example.hrsample.entity.Employees;
import com.example.hrsample.service.DepartmentsService;
import com.example.hrsample.service.EmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private DepartmentsService departmentsService;


    @GetMapping(value = {"/", "/list"})
    public String getListEmployees(ModelMap mm,
                                   @RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName,
                                   @RequestParam(value = "departments", required = false) Departments departments,
                                   @PageableDefault(size = 10) Pageable page){
        String oFirstName = Optional.ofNullable(firstName).orElse("");
        String oLastName = Optional.ofNullable(lastName).orElse("");
        //Page<Employees> result = employeesService.getFilterByNameOrDepartmentsAndPage(oFirstName, oLastName, departments, page);
        Page<Employees> result = employeesService.getAllAndPage(page);
        mm.addAttribute("data", result);
        mm.addAttribute("listDepartment", departmentsService.getAll());

        return "employees";
    }
}
