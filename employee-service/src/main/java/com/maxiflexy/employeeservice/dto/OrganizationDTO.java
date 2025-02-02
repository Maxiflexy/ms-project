package com.maxiflexy.employeeservice.dto;

import lombok.Data;

@Data
public class OrganizationDTO {
    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private String createdDate;
}
