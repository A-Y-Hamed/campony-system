package com.myproject.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "project_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
public class ProjectData {
    @Id
    @Column(name = "project_no")
    private Integer number;
    @Column(name = "project_name")
    private String name;
    private String location;
    @Column(name = "department_no")
    private String deptno;
    private String department;
}
