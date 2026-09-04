package com.myproject.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private Integer id;

    @Column(name = "empname")
    private String name;

    private String address;
    private Double salary;
    private LocalDate hiringdate;
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Department department;

    //public Employee(String name,String address,Double salary,LocalDate hiringdate,LocalDate birthdate,Department dept)
   // {
      //  this.name=name;
     //   this.address=address;
      //  this.salary=salary;
       // this.hiringdate=hiringdate;
       // this.birthdate=birthdate;
        //this.department=dept;
   //}
}