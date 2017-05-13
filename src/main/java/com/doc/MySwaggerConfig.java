package com.doc;

/**
 * Created by chenwt
 */

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;

@Configuration
@EnableSwagger2
public class MySwaggerConfig {

     @Bean
     public Docket restApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
                 .build();
     }


     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("API Test  ")
                 .description("MyAPITest Description")
                 .contact(new Contact("chenwt", "http://www.baidu.com", "feiniaoying@163.com"))
                 .license("Apache 2.0")
                 .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                 .version("1.0.0")
                 .build();
     }
}
