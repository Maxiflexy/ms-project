package com.maxiflexy.organisationservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record OrganizationDTO (
        Long id,
        String organizationName,
        String organizationDescription,
        String organizationCode,
        String createdDate
){ }
