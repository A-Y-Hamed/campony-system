package com.myproject.company.repository;

import com.myproject.company.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByNameContainingIgnoreCase(String name);

    List<Department> findByLocationContainingIgnoreCase(String location);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO department (deptno, deptname, location) VALUES (:id, :name, :location)", nativeQuery = true)
    void insertDepartment(@Param("id") Long id, @Param("name") String name, @Param("location") String location);
}