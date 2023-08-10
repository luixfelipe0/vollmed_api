package med.voll.api.infra.security.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                                .info(new Info()
                                        .title("Vollmed.API")
                                        .description("API Rest que contém as funcionalidades de CRUD, envolvendo médicos e " +
                                                "pacientes, além do cadastro e cancelamento de consultas. Desenvolvido usando Java e Spring Boot.")
                                        .contact(new Contact()
                                                .name("Luiz Felipe Santos Silva")
                                                .email("luiz_santos1811@outlook.com"))
                                .license(new License()
                                        .name("Apache 4.0.0")
                                        .url("http://voll.med/api/licenca")));
    }

}
