package com.maxiflexy.organisationservice.mapper;

import com.maxiflexy.organisationservice.dto.OrganizationDTO;
import com.maxiflexy.organisationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapToOrganizationDTO(Organization organization){
        return OrganizationDTO.builder()
                .id(organization.getId())
                .organizationName(organization.getOrganizationName())
                .organizationDescription(organization.getOrganizationDescription())
                .organizationCode(organization.getOrganizationCode())
                .createdDate(organization.getCreatedDate())
                .build();
    }

    public static Organization mapToOrganization(OrganizationDTO organizationDTO){
        return Organization.builder()
                .id(organizationDTO.id())
                .organizationName(organizationDTO.organizationName())
                .organizationDescription(organizationDTO.organizationDescription())
                .organizationCode(organizationDTO.organizationCode())
                .createdDate(organizationDTO.createdDate())
                .build();
    }
}
