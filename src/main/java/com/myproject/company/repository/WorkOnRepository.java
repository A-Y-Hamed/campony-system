package com.myproject.company.repository;

import com.myproject.company.entity.WorkOn;
import com.myproject.company.entity.WorkOnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOnRepository extends JpaRepository<WorkOn, WorkOnId> {
}
