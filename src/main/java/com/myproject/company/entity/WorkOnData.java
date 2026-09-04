package com.myproject.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workon_data")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class WorkOnData {
    @Id
    @Column(name = "employee_no")
    private Integer idE;
    @Column(name = "employee_name")
    private String nameE;
    @Column(name = "project_no")
    private Integer idP;
    @Column(name = "project_name")
    private String nameP;
}
