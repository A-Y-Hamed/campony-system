package com.myproject.company.services;

import com.myproject.company.entity.WorkOn;
import com.myproject.company.entity.WorkOnData;
import com.myproject.company.entity.WorkOnId;

import java.util.List;

public interface WorkOnService {
    void saveWorkOn(WorkOn workOn);
    void deleteWorkOn(WorkOnId id);
    List<WorkOnData> searchWorkOn(String searchBy,String keyword);
}
