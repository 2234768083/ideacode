/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .groupName("MongoPlus")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.anwen.mongoa.controller"))
                .paths(PathSelectors.any())
                .build();
    }




    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("MongoPlus测试工程")
                .contact(new Contact("jiachaoyang", "https://gitee.com/anwena", "j15030047216@163.com"))
                .termsOfServiceUrl("https://gitee.com/anwena/mongo-plus")
                .version("v1.0")
                .title("MongoPlus测试工程")
                .build();
    }
}
