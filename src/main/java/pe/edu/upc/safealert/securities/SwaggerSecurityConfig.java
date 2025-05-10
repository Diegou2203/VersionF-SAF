package pe.edu.upc.safealert.securities;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerSecurityConfig {
    @Bean
    public OpenAPI  customerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API JWT Authentication")
                    .version("1.0")
                    .description("API Protection Authentication"))
                .addSecurityItem(new SecurityRequirement().addList("BearerAuthentication"))
                .components(new Components( )
                        .addSecuritySchemes("BearerAuthentication", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
