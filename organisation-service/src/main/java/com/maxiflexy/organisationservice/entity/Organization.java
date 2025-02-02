package com.maxiflexy.organisationservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String organizationName;
    private String organizationDescription;
    @Column(nullable = false, unique = true)
    private String organizationCode;
    @CreationTimestamp
    private String createdDate;
}
