package com.clinic.clinicsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Clinic System API")
                        .version("1.0.0")
                        .description("Tài liệu và thử nghiệm các API của hệ thống phòng khám")
                        .contact(new Contact()
                                .name("Vu Nguyen")
                                .email("contact@clinic.com")
                        )
                );
    }
}
