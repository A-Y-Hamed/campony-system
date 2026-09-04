package com.myproject.company.service_impl;

import com.myproject.company.entity.WorkOn;
import com.myproject.company.entity.WorkOnData;
import com.myproject.company.entity.WorkOnId;
import com.myproject.company.repository.WorkOnDataRepository;
import com.myproject.company.repository.WorkOnRepository;
import com.myproject.company.services.WorkOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WorkOnServiceImpl implements WorkOnService {

    @Autowired
    private WorkOnRepository workOnRepository;
    @Autowired
    private WorkOnDataRepository workOnDataRepository;

    @Override
    public void saveWorkOn(WorkOn workOn) {
        if(workOn !=null)
        {
            workOnRepository.save(workOn);
        }
    }

    @Override
    public void deleteWorkOn(WorkOnId id) {
        if(id != null)
        {
            workOnRepository.deleteById(id);
        }

    }

@Override
    public List<WorkOnData> searchWorkOn(String searchBy, String keyword) {
        // إذا كانت كلمة البحث فارغة، يتم إرجاع جميع البيانات
        if (keyword == null || keyword.trim().isEmpty()) {
            return workOnDataRepository.findAll();
        }

        String cleanKeyword = keyword.trim();

        switch (searchBy) {
            case "Employee_No":
                try {
                    Integer idE = Integer.parseInt(cleanKeyword);
                    return workOnDataRepository.findByIdE(idE);
                } catch (NumberFormatException e) {
                    return Collections.emptyList(); // في حال إدخال قيمة غير رقمية لرقم الموظف
                }

            case "Employee_Name":
                return workOnDataRepository.findByNameEContainingIgnoreCase(cleanKeyword);

            case "Project_No":
                try {
                    Integer idP = Integer.parseInt(cleanKeyword);
                    return workOnDataRepository.findByIdP(idP);
                } catch (NumberFormatException e) {
                    return Collections.emptyList(); // في حال إدخال قيمة غير رقمية لرقم المشروع
                }

            case "Project_Name":
                return workOnDataRepository.findByNamePContainingIgnoreCase(cleanKeyword);

            default:
                return workOnDataRepository.findAll();
        }
    }
}
