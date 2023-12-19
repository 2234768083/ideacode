package com.mongodb.utils;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {

    @Bean
    public Docket defaultApi2() {
        // 创建Docket对象，指定DocumentationType为SWAGGER_2
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder() // 设置API信息
                        .title("mongodb大作业") // API标题
                        .description("springboot+mongodb+logback+layui+knife4j") // API描述
                        .contact(new Contact("yzy", "127.0.0.1:3000/doc.html", "2387717648@qq.com")) // 联系人信息
                        .version("1.0") // API版本号
                        .build()) // 构建ApiInfo对象
                // 设置分组名称
                .groupName("v3.0")
                .select() // 选择API
                // 指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.mongodb.controller"))
                .paths(PathSelectors.any()) // 任意路径
                .build(); // 构建Docket对象
        return docket; // 返回Docket对象
    }

}