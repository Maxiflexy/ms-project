package com.maxiflexy.employeeservice.controller;

import com.maxiflexy.employeeservice.dto.ApiResponseDTO;
import com.maxiflexy.employeeservice.dto.EmployeeDTO;
import com.maxiflexy.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(
        name = "Employee-Controller/Service",
        description = "Employee controller exposes REST APIs for employee service"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    @Operation(
            summary = "Save Employee REST APIs",
            description = "Save Employee REST APIs is used to save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployee, CREATED);
    }


    @Operation(
            summary = "Get Employee REST APIs",
            description = "Get Employee REST APIs is used to get a employee object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{employee-id}")
    public ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable("employee-id") Long id){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(apiResponseDTO);
    }

}
