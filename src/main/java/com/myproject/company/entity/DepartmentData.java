package com.myproject.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "department_data")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentData {
    @Id
    @Column(name = "Department_No")
    private Long id;
    @Column(name = "Department_Name")
    private String name;
    @Column(name = "Location")
    private String Location;
}

