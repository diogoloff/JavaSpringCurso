package br.com.javaspringcurso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("JavaSpring Curso")
                .version("v1")
                .description("Utilizando Java 21")
                .termsOfService("https://www.twitch.tv/loffstream")
                .license(new License().name("Apache 2.0")
                    .url("https://www.twitch.tv/loffstream")));
    }

}
