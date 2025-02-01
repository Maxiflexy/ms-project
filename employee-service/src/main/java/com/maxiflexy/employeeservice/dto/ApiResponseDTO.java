package com.maxiflexy.employeeservice.dto;

import lombok.Data;

@Data
public class ApiResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}
