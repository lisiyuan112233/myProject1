package com.sia;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.sia.mapper")
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
public class orderApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderApplication.class, args);
        log.info("server started");
    }
}
