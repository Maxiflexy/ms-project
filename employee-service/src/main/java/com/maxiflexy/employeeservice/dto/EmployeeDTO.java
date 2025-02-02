package com.maxiflexy.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "EmployeeDTO Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;

    @Schema(description = "Employee FirstName")
    private String firstName;
    @Schema(description = "Employee LastName")
    private String lastName;
    @Schema(description = "Employee Email")
    private String email;
    @Schema(description = "Employee DepartmentCode")
    private String departmentCode;
    @Schema(description = "Employee OrganizationCode")
    private String organizationCode;
}
