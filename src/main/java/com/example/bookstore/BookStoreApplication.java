package com.example.bookstore;


import com.example.bookstore.business.concretes.BookManager;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "BookStore Service API",
                description = "BookStore crud services",
                version = "v1"
        )
)
@EnableMethodSecurity
public class BookStoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
        long start = System.nanoTime();
        System.out.println(start);
    }

//    @Bean
//    public Docket api() {
//        return new Docket( DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.bookstore"))
//                .build();
//    }
}
