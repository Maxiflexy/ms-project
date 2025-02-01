package com.maxiflexy.employeeservice.service.impl;

import com.maxiflexy.employeeservice.dto.ApiResponseDTO;
import com.maxiflexy.employeeservice.dto.DepartmentDTO;
import com.maxiflexy.employeeservice.dto.EmployeeDTO;
import com.maxiflexy.employeeservice.entity.Employee;
import com.maxiflexy.employeeservice.repository.EmployeeRepository;
import com.maxiflexy.employeeservice.service.APIClient;
import com.maxiflexy.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient feignClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);


        return new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode());

        // using rest template to make a get request call
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity
//                ("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDTO.class);
        //DepartmentDTO departmentDTO = responseEntity.getBody();



        // using a web client from webflux to make a get request call
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();



        // using feign client to make a get request call
        DepartmentDTO departmentDTO = feignClient.getDepartment(employee.getDepartmentCode());

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }


}
