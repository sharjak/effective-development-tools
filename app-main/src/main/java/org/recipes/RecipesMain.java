package org.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "org.recipes.adapter.jdbc")
public class RecipesMain extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RecipesMain.class, args);
    }
}