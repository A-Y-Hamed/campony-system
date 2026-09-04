package com.myproject.company.service_impl;

import com.myproject.company.entity.Employee;
import com.myproject.company.entity.EmployeeData;
import com.myproject.company.repository.EmployeeDataRepository;
import com.myproject.company.repository.EmployeeRepository;
import com.myproject.company.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeDataRepository employeeDataRepository;
    @Override
    public List<EmployeeData> getAllEmployees() {
        return employeeDataRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeData> searchEmployee(String searchBy, String keyword) {
        if(keyword == null || keyword.trim().isEmpty())
        {
            return getAllEmployees();
        }
        else
        {
            switch (searchBy) {
                case "number":
                    try {
                        Integer id = Integer.parseInt(keyword.trim());
                        return employeeDataRepository.findByNumber(id);

                    } catch (Exception e) {
                        return Collections.emptyList();
                    }
                case "name":
                    return employeeDataRepository.findByNameContainingIgnoreCase(keyword.trim());
                case "address":
                    return employeeDataRepository.findByAddressContainingIgnoreCase(keyword.trim());
                case "salary":
                    try {
                        return employeeDataRepository.findBySalary(Double.parseDouble(keyword.trim()));
                    } catch (Exception e) {
                        return Collections.emptyList();
                    }
                case "hiringDate":
                    try {
                        return employeeDataRepository.findByHiringdate(LocalDate.parse(keyword.trim()));
                    } catch (Exception e)
                    {
                        return Collections.emptyList();
                    }
                case "birthDate":
                    try {
                        return employeeDataRepository.findByBirthdate(LocalDate.parse(keyword.trim()));
                    }
                    catch (Exception e)
                    {
                        return Collections.emptyList();
                    }

                case "deptName": return employeeDataRepository.findByDepartmentNameContainingIgnoreCase(keyword.trim());
                default: return getAllEmployees();
            }
        }

    }
}
