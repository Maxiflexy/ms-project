package com.maxiflexy.organisationservice.repository;

import com.maxiflexy.organisationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String orgCode);
}
