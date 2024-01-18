package com.project.blog.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwagggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	String schemeName = "bearerScheme";

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("blogging-api").pathsToMatch("/api/**").build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(apiInfo())
				.addSecurityItem(new SecurityRequirement().addList(schemeName))
				.components(new Components().addSecuritySchemes(schemeName,new SecurityScheme()
						.name(schemeName)
						.type(SecurityScheme.Type.HTTP)
						.bearerFormat("JWT")
						.scheme("bearer")
						));
	}

	private Info apiInfo() {
		return new Info().title("Blogging Application")
				.description("This project is a spring boot project").version("1.0")
				.termsOfService("Terms of Service")
				.contact(new Contact().name("Aryan")
				.url("xyz.com").email("xyz@gmail.com"))
				.license(new License().name("License of APIS").url("API license URL"));
	}



}
