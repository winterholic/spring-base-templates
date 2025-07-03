package com.winterholic.basic.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local", "dev"})
public class SwaggerConfig {

    private static final String AUTHORIZATION = "Authorization";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Authorization", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .name("Authorization")
                        )
                )
                .info(new Info()
                        .title("BASIC API Document")
                        .version("1.0.0")
                        .description("API 목록을 선택해주세요.")
                )
                .addSecurityItem(new SecurityRequirement().addList("Authorization"));
    }

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("01. 전체 API")
                .packagesToScan("com.winterholic.basic")
                .build();
    }

    @Bean
    public GroupedOpenApi baseApi() {
        return GroupedOpenApi.builder()
                .group("02. 기본 API")
                .packagesToScan("com.winterholic.basic.domain.base")
                .build();
    }

    @Bean
    public GroupedOpenApi memberApi() {
        return GroupedOpenApi.builder()
                .group("03. 멤버 API")
                .packagesToScan("com.winterholic.basic.domain.member")
                .build();
    }

    @Bean
    public GroupedOpenApi mergeApi() {
        return GroupedOpenApi.builder()
                .group("04. 혼합 테스트 API")
                .packagesToScan("com.winterholic.basic.domain.member", "com.winterholic.basic.domain.base")
                .build();
    }
}
