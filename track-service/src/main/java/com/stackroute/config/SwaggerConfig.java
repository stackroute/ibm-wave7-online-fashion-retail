package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Indicates this as a configuration class
 */
@Configuration
/**Enable swagger support in the class*/
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Creates a Docket bean to configure Swagger 2 for the application
     */
    @Bean
    public Docket api() {
        /**Return API documentation*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.stackroute.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
