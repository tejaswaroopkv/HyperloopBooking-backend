package com.fightbook.commonManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class SwaggerConfiguration {
	@Bean
	public Docket mySwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/flight/common/**"))
				.apis(RequestHandlerSelectors.basePackage("com.fightbook.commonManager"))
				.build()
				.apiInfo(apiInfo())
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Common Manager API")
				.description("MicroService to manage the common data")
				.version("5.4")
				.contact(new Contact("Tejaswaroop", "https://www.localhost:4200/user/DashBoard/bookfights", "teja@gmail.com"))
				.build()
				;
	}
}
