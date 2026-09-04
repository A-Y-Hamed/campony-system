package com.myproject.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Table(name = "employee_data")
@Immutable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeData {

    @Id

    private Integer number;
    private String name;
    private String address;
    private Double salary;

    @Column(name = "hiring_date")
    private LocalDate hiringdate;

    @Column(name = "date_of_birth")
    private LocalDate birthdate;

    @Column(name = "department_no")
    private Integer departmentNumber;

    @Column(name = "department")
    private String departmentName;
}