package com.cg.socialmedia.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SocialMediaAppConfig {
	@Bean 
	public Docket socialMediaModule() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.socialmedia"))//here use your base package name
				.paths(PathSelectors.regex("/api.*"))//use the path given in in request mapping of controller e.g:if @RequestMapping("/api") use /api.*
				.build()
				.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Social Media Application API Documentation", 
				"This is Social Media Application info", 
				"1.0", 
				"public terms of services",
				new Contact("SM Teams", "http://socialmediateam.com", "smteam@gmail.com"),
				"GPL",
				"http://gpl.info"
				);
		return apiInfo;
	}
}

