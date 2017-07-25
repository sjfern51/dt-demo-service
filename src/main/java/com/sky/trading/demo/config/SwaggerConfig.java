package com.sky.trading.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .apiInfo(createApiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .paths(PathSelectors.regex("/demo/.*"))
                .build()
                .tags(new Tag("demo", ""));
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Service")
                .description("An example service for demonstration purposes")
                .version("1.0")
                .build();
    }
}
