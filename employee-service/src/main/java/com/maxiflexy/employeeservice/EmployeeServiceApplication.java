package com.maxiflexy.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs documentation",
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
				description = "Employee Service Docs",
				url = "www.youtube.com"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

}
