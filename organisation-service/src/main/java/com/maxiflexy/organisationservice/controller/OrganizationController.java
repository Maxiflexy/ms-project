package com.maxiflexy.organisationservice.controller;

import com.maxiflexy.organisationservice.dto.OrganizationDTO;
import com.maxiflexy.organisationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        OrganizationDTO savedOrgDTO = organizationService.saveOrganization(organizationDTO);

        return new ResponseEntity<>(savedOrgDTO, CREATED);
    }

    @GetMapping("{org-code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("org-code") String orgCode){
        OrganizationDTO savedOrgDTO = organizationService.getOrganizationByCode(orgCode);

        return ResponseEntity.ok(savedOrgDTO);
    }
}
