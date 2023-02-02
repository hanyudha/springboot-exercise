package com.example.hrsample.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(schema = "public", name = "departments")
public class Departments extends BaseEntity {
    @NotNull
    @NotEmpty(message = "Department can not be empty")
    @Size(min = 0, max = 30)
    @Column(name = "department_name", length = 30)
    private String department_name;
}
