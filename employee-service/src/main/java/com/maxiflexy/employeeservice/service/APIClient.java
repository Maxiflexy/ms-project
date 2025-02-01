package com.maxiflexy.employeeservice.service;

import com.maxiflexy.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDTO getDepartment(@PathVariable("department-code") String code);
}
