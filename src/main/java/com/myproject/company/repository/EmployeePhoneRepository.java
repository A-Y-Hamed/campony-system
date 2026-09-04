package com.myproject.company.repository;

import com.myproject.company.entity.EmployeePhone;
import com.myproject.company.entity.EmployeePhoneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePhoneRepository extends JpaRepository<EmployeePhone, EmployeePhoneId> {
    List<EmployeePhone> findById(Integer id);
}
