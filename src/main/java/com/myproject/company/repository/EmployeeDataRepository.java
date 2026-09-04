package com.myproject.company.repository;

import com.myproject.company.entity.Employee;
import com.myproject.company.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData,Integer> {

    List<EmployeeData> findByNumber(Integer id);

    List<EmployeeData> findByNameContainingIgnoreCase(String name);

    List<EmployeeData> findByAddressContainingIgnoreCase(String address);

    List<EmployeeData> findBySalary(Double salary);

    List<EmployeeData> findByHiringdate(LocalDate hiringdate);

    List<EmployeeData> findByBirthdate(LocalDate birthdate);

    List<EmployeeData> findByDepartmentNameContainingIgnoreCase(String deptName);
}
