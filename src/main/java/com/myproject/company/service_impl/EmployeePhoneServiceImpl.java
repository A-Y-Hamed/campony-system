package com.myproject.company.service_impl;

import com.myproject.company.entity.EmployeePhone;
import com.myproject.company.entity.EmployeePhoneId;
import com.myproject.company.repository.EmployeePhoneRepository;
import com.myproject.company.services.EmployeePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePhoneServiceImpl implements EmployeePhoneService {
    @Autowired
    private EmployeePhoneRepository employeePhoneRepository;

    @Override
    public void savePhone(EmployeePhone phone) {
        if(phone != null || phone.getId() != null)
        {
        employeePhoneRepository.save(phone);
        }
    }

    @Override
    public void deletePhone(EmployeePhoneId id) {
        if(id != null)
        {
            employeePhoneRepository.deleteById(id);
        }

    }
}
