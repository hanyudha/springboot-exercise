package com.example.hrsample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(schema = "public", name = "jobs")
public class Jobs extends BaseEntity {
    private String job_title;
    private BigDecimal min_salary;
    private BigDecimal max_salary;
}
