package com.myproject.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_phones")
@IdClass(EmployeePhoneId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePhone {

    @Id
    @Column(name = "EMPNO")
    private Integer id;

    @Id
    @Column(name = "PHONE")
    private String phone;
}

