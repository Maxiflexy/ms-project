package com.maxiflexy.organisationservice.controller;

import com.maxiflexy.organisationservice.dto.OrganizationDTO;
import com.maxiflexy.organisationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(
        name = "Organization-Controller/Service",
        description = "Organization controller exposes REST APIs for organization service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Save Organization REST APIs",
            description = "Save Organization REST APIs is used to save organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        OrganizationDTO savedOrgDTO = organizationService.saveOrganization(organizationDTO);

        return new ResponseEntity<>(savedOrgDTO, CREATED);
    }


    @Operation(
            summary = "Get Organization REST APIs",
            description = "Get Organization REST APIs is used to get a organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{org-code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("org-code") String orgCode){
        OrganizationDTO savedOrgDTO = organizationService.getOrganizationByCode(orgCode);

        return ResponseEntity.ok(savedOrgDTO);
    }
}
