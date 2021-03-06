package com.gang.common.swagger.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname SwaggerConfig
 * @Description TODO
 * @Date 2020/1/1 22:11
 * @Created by zengzg
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    private String serverPort;

    @Value("${gang.common.swagger.basePackage}")
    private String basePackage = "com.gang";


    @Bean
    public Docket createRestApi() {
        logger.info("------> this is in createRestApi , base package {}  <-------", basePackage);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                //                .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))  //只显示加了注解的api
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        logger.info("------> this is in apiInfo ,server port :{} <-------", serverPort);
        return new ApiInfoBuilder()
                .title("管理系统")
                .description("powered by By-Health")
                .termsOfServiceUrl("http://localhost:" + serverPort + "/swagger-ui.html")
                //.contact(contact)
                .version("1.0")
                .build();
    }

}
