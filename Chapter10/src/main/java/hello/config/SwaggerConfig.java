package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author liurong
 * @Date 2019/12/15 21:05
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

     @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").
                select().paths(PathSelectors.regex("/.*")).build();
    }

     private ApiInfo apiInfo(){
         return  new ApiInfoBuilder().title("接口文档").
                 contact(new Contact("liurong","","5278")).
                 description("这是我得swaggerui生成得接口文档").
                 version("1.0.0.0").
                 build();
     }
}
