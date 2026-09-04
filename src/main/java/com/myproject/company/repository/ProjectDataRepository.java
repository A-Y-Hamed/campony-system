package com.myproject.company.repository;

import com.myproject.company.entity.ProjectData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDataRepository extends JpaRepository<ProjectData,Integer> {

    List<ProjectData> findByNumber(Integer id);

    List<ProjectData> findByNameContainingIgnoreCase(String name);

    List<ProjectData> findByLocationContainingIgnoreCase(String location);

    List<ProjectData> findByDepartmentContainingIgnoreCase(String deptName);

}
