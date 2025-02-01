package com.maxiflexy.departmentservice.controller;

import com.maxiflexy.departmentservice.dto.DepartmentDTO;
import com.maxiflexy.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO request){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(request);

        return new ResponseEntity<>(savedDepartment, CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String code){
        DepartmentDTO savedDepartment = departmentService.getDepartmentByCode(code);

        return new ResponseEntity<>(savedDepartment, OK);
    }
}
