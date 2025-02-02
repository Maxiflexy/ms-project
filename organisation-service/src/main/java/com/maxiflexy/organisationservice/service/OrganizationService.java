package com.maxiflexy.organisationservice.service;

import com.maxiflexy.organisationservice.dto.OrganizationDTO;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO getOrganizationByCode(String orgCode);
}
