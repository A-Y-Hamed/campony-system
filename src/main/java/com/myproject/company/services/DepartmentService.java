package com.myproject.company.services;

import com.myproject.company.entity.Department;
import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartmentById(Long id);

    Department getDepartmentById(Long id);

    List<Department> searchDepartments(String searchBy, String keyword);
}