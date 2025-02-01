package com.maxiflexy.employeeservice.controller;

import com.maxiflexy.employeeservice.dto.ApiResponseDTO;
import com.maxiflexy.employeeservice.dto.EmployeeDTO;
import com.maxiflexy.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployee, CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable("employee-id") Long id){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(apiResponseDTO);
    }

}
