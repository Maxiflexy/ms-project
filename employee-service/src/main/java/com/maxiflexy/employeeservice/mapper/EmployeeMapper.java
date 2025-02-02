package com.maxiflexy.employeeservice.mapper;

import com.maxiflexy.employeeservice.dto.EmployeeDTO;
import com.maxiflexy.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode())
                .organizationCode(employee.getOrganizationCode())
                .build();
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );
    }
}
