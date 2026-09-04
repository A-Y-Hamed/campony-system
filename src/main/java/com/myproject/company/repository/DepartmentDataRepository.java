package com.myproject.company.repository;

import com.myproject.company.entity.DepartmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDataRepository extends JpaRepository<DepartmentData, Long> {

}