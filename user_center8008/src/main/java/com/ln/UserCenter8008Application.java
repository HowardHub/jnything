package com.ln;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/9 14:25
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ln.mapper")
@EnableSwagger2
public class UserCenter8008Application {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 扫包的范围,也就是把哪些包生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.ln.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        //title文档标题
        //description文档描述
        //termsOfServiceUrl自定义地址
        //version版本号
        return new ApiInfoBuilder().title("jnything").description("用户服务swagger")
                .version("1.0").build();
    }



    public static void main(String[] args) {
        SpringApplication.run(UserCenter8008Application.class, args);
    }

}
