package com.myproject.company.service_impl;

import com.myproject.company.entity.Department;
import com.myproject.company.repository.DepartmentRepository;
import com.myproject.company.services.DepartmentService; // استيراد الـ interface من مجلد services
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        if (department != null && department.getId() != null) {
            if (departmentRepository.existsById(department.getId())) {

                departmentRepository.save(department);
            } else {

                departmentRepository.insertDepartment(department.getId(), department.getName(), department.getLocation());
            }
        }
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        if (id != null) {
            departmentRepository.deleteById(id);
        }
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);

    }

    @Override
    public List<Department> searchDepartments(String searchBy, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllDepartments();
        }

        switch (searchBy) {
            case "number":
                try {
                    Long id = Long.parseLong(keyword.trim());
                    return departmentRepository.findById(id)
                            .map(Collections::singletonList)
                            .orElse(Collections.emptyList());
                } catch (Exception e) {
                    return Collections.emptyList();
                }
            case "name":
                return departmentRepository.findByNameContainingIgnoreCase(keyword.trim());
            case "location":
                return departmentRepository.findByLocationContainingIgnoreCase(keyword.trim());
            
            default:
                return getAllDepartments();
        }
    }
}