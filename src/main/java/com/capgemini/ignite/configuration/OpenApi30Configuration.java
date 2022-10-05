package com.capgemini.ignite.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Sample API",
        version = "v1",
        description = "This is a description",
        termsOfService = "Terms of Service"))
public class OpenApi30Configuration {
    // https://springdoc.org/
}
