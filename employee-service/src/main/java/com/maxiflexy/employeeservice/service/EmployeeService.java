package com.maxiflexy.employeeservice.service;

import com.maxiflexy.employeeservice.dro.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);
}
