package com.myproject.company.repository;


import com.myproject.company.entity.WorkOnData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkOnDataRepository extends JpaRepository<WorkOnData,Integer> {

    List<WorkOnData> findByIdE(Integer id);
    List<WorkOnData> findByNameEContainingIgnoreCase(String name);
    List<WorkOnData> findByIdP(Integer id);
    List<WorkOnData> findByNamePContainingIgnoreCase(String name);
}
