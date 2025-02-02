package com.maxiflexy.organisationservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrganizationDTO {
    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private String createdDate;
}
