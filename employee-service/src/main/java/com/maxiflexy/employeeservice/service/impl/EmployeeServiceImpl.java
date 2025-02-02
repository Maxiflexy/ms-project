package com.maxiflexy.employeeservice.service.impl;

import com.maxiflexy.employeeservice.dto.ApiResponseDTO;
import com.maxiflexy.employeeservice.dto.DepartmentDTO;
import com.maxiflexy.employeeservice.dto.EmployeeDTO;
import com.maxiflexy.employeeservice.dto.OrganizationDTO;
import com.maxiflexy.employeeservice.entity.Employee;
import com.maxiflexy.employeeservice.mapper.EmployeeMapper;
import com.maxiflexy.employeeservice.repository.EmployeeRepository;
import com.maxiflexy.employeeservice.service.APIClient;
import com.maxiflexy.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient feignClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment") // you can use either circuit breaker or the retry pattern
    //@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDTO getEmployeeById(Long employeeId) {
        log.info("inside getEmployee by id method");
        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

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

        OrganizationDTO organizationDTO = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employeeDTO.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDTO.class)
                .block();

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDTO(organizationDTO);

        return apiResponseDTO;
    }

    public ApiResponseDTO getDefaultDepartment(Long employeeId, Exception exception){
        log.info("inside getEmployee by id method for fall back");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("R&D Dpt");
        departmentDTO.setDepartmentCode("RD001");
        departmentDTO.setDepartmentDescription("Research and Development department");

        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }
}
