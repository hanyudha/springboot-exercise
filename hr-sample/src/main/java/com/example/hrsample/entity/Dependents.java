package com.example.hrsample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(schema = "public", name = "dependents")
public class Dependents extends BaseEntity{
    @NotNull
    @NotEmpty(message = "Name can not be empty")
    private String first_name;

    private String last_name;

    @NotNull
    @NotEmpty(message = "Relationship can not be empty")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employees id_employee;
}
