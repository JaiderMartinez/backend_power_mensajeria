package com.reto.twilio.infrastructure.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Microservicio Mensajeria")
                        .version("1.0")
                        .description("Envio de mensajes a los numeros telefonicos de los clientes con el pin del pedido")
                        .termsOfService("http://swagger.io/terms/")
                );
    }
}
