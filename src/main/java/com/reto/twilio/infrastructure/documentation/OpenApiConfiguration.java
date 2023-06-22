package com.reto.twilio.infrastructure.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("Microservicio Mensajeria")
                        .version("1.0")
                        .description("Envio de mensajes a los numeros telefonicos de los clientes con el pin del pedido")
                        .termsOfService("http://swagger.io/terms/")
                )
                .security(Collections.singletonList(new SecurityRequirement().addList("bearerAuth")));
    }
}
