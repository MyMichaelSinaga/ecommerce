package com.my.challenge.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.my.challenge.controller"))
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> postPaths() {
        return or(regex("/main.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Challenge from HomeCredit")
                .description("Spring boot rest API - HomeCredit Online Test")
                .version("1.0.0")
                .build();
    }
}
