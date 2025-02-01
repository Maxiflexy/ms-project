package com.maxiflexy.employeeservice.service;

import com.maxiflexy.employeeservice.dto.ApiResponseDTO;
import com.maxiflexy.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    ApiResponseDTO getEmployeeById(Long employeeId);
}
