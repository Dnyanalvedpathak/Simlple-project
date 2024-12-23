package com.crm.crm_application_dev.configuarations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI myCustomConfig(){
        return new OpenAPI()
                .info(
                new Info().title("CRM Application APIs")
        );
    }
}