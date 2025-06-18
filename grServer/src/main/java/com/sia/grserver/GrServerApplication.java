package com.sia.grserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@MapperScan("com.sia.grserver.mapper")
public class GrServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrServerApplication.class, args);
    }

}
