package com.maxiflexy.departmentservice.service.impl;

import com.maxiflexy.departmentservice.dto.DepartmentDTO;
import com.maxiflexy.departmentservice.entity.Department;
import com.maxiflexy.departmentservice.mapper.DepartmentMapper;
import com.maxiflexy.departmentservice.repository.DepartmentRepository;
import com.maxiflexy.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);

        return DepartmentMapper.mapToDepartmentDTO(department);
    }
}
