package com.maxiflexy.employeeservice.repository;

import com.maxiflexy.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
