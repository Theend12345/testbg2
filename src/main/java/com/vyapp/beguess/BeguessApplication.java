package com.vyapp.beguess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BeguessApplication {


    public String PORT = System.getenv("PORT");

    public static void main(String[] args) {
        SpringApplication.run(BeguessApplication.class, args);
    }

}
