package com.myproject.company.services;

import com.myproject.company.entity.Department;
import com.myproject.company.entity.Employee;
import com.myproject.company.entity.EmployeeData;

import java.util.List;

public interface EmployeeService {

    List<EmployeeData> getAllEmployees();

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

    Employee getEmployeeById(Integer id);

    List<EmployeeData> searchEmployee(String searchBy, String keyword);
}
