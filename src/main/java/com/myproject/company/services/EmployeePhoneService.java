package com.myproject.company.services;


import com.myproject.company.entity.EmployeePhone;
import com.myproject.company.entity.EmployeePhoneId;


public interface EmployeePhoneService {
    void savePhone(EmployeePhone phone);
    void deletePhone(EmployeePhoneId id);

}
