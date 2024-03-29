package com.igor.feedbacker.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("prod")
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(Arrays.asList(apiKey()));
	}

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("REST API Document - Feedbacker")
	            .description(""
	            		+ "de name para o email cadastrado e 'string' de senha para a senha cadastrada."
	            		+ "Será gerado um token, basta adicioná-lo em 'Authorize' seguido da nomeclatura Bearer. ")
	            
	            .termsOfServiceUrl("")
	            .version("1.0")
	            .build();
	}

	private ApiKey apiKey() {
	    return new ApiKey("Bearer", "Authorization", "header");
	}
}
