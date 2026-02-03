package io.acsint.birthdayservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Birthday Service API")
                        .version("0.0.1")
                        .description("API documentation for Birthday Service")
                        .contact(new Contact()
                                .name("Birthday Service Team")
                                .url("https://github.com")));
    }
}
