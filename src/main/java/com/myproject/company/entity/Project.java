package com.myproject.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectno")
    private Integer number;
    @Column(name = "projectname")
    private String name;
    private String location;
    @ManyToOne
    @JoinColumn(name = "deptno")
    private Department department;


}
