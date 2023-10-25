package edu.persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.persons.*" })
@EntityScan(basePackages = "edu.persons.*")
public class PersonsApi {
    public static void main(String[] args) {
        SpringApplication.run(PersonsApi.class, args);
    }
}