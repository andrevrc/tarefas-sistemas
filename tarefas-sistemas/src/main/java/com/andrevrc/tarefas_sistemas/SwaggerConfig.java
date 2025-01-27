package com.andrevrc.tarefas_sistemas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}")
    private String versao;

    @Value("${spring.application.name}")
    private String descricao;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                    new Info()
                            .title("Tarefas dos Sistemas")
                            .description(descricao)
                            .version(versao)
                )
                .components(
                    new Components().addSecuritySchemes("jwtAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .scheme("bearer")
                        .name("Authorization")
                        .bearerFormat("JWT")             
                    )
                )
                .addSecurityItem(new SecurityRequirement().addList("jwtAuth"))
        ;
    }
}
