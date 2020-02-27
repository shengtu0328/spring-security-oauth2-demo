package com.xrq.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xrq.oauth2.mapper")
@SpringBootApplication
public class SpringSecurityOauth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2DemoApplication.class, args);
    }



}
