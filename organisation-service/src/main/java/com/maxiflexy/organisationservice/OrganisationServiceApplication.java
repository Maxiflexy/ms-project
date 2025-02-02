package com.maxiflexy.organisationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Maxikolbe",
						email = "onyekachimaximillian@gmail.com",
						url = "https://www.mycode_tutorial.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.mycode_tutorial.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service Docs",
				url = "www.youtube.com"
		)
)
@SpringBootApplication
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}

}
