package com.example.hrsample.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(schema = "public", name = "employees")
public class Employees extends BaseEntity {
    @NotNull
    @NotEmpty(message = "First Name can not be empty")
    @Column(name = "first_name", length = 150)
    private String first_name;

    @Column(name = "last_name", length = 150)
    private String last_name;

    @NotNull
    @NotEmpty(message = "Email can not be empty")
    @Size(min = 0, max = 50)
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @NotNull
    @NotEmpty(message = "Phone Number can not be empty")
    private String phone_number;
    private LocalDate hire_date;
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "id_job")
    private Jobs id_job;

    @ManyToOne
    @JoinColumn(name = "id_manager")
    private Employees id_manager;

    @ManyToOne
    @JoinColumn(name = "id_departments")
    private Departments id_departments;
}
