package com.maxiflexy.departmentservice.controller;

import com.maxiflexy.departmentservice.dto.DepartmentDTO;
import com.maxiflexy.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(
        name = "Department-Controller/Service",
        description = "Department controller exposes REST APIs for department service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST APIs",
            description = "Save Department REST APIs is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO request){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(request);

        return new ResponseEntity<>(savedDepartment, CREATED);
    }

    @Operation(
            summary = "Get Department REST APIs",
            description = "Get Department REST APIs is used to get a department object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String code){
        DepartmentDTO savedDepartment = departmentService.getDepartmentByCode(code);

        return new ResponseEntity<>(savedDepartment, OK);
    }
}
