package kr.co.sample.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(swaggerInfo());
    }

    private Info swaggerInfo() {
        return new Info()
                .title("다양한 샘플 예시 프로젝트")
                .description("다양한 샘플을 확인 할 수 있는 샘플 프로젝트")
                .version("1.0")
                .contact(new Contact()
                        .name("이인석")
                        .email("dlstjr9068@gmail.com"));
    }
}
