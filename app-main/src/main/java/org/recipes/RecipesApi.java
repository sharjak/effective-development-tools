package org.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.recipes.*" })
@EntityScan(basePackages = "org.recipes.*")
public class RecipesApi extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RecipesApi.class, args);
    }
}