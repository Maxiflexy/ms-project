package com.maxiflexy.organisationservice.service.impl;

import com.maxiflexy.organisationservice.dto.OrganizationDTO;
import com.maxiflexy.organisationservice.entity.Organization;
import com.maxiflexy.organisationservice.mapper.OrganizationMapper;
import com.maxiflexy.organisationservice.repository.OrganizationRepository;
import com.maxiflexy.organisationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);

        var savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDTO(savedOrganization);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String orgCode) {
        Organization organization = organizationRepository.findByOrganizationCode(orgCode);

        return OrganizationMapper.mapToOrganizationDTO(organization);
    }
}
