package com.maxiflexy.organisationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(
        description = "OrganizationDTO Model Information"
)
@Builder
@Data
public class OrganizationDTO {
    private Long id;
    @Schema(description = "Organization Name")
    private String organizationName;
    @Schema(description = "Organization description")
    private String organizationDescription;
    @Schema(description = "Organization Code")
    private String organizationCode;
    @Schema(description = "Organization created date")
    private String createdDate;
}
