package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@MapperScan("com.cc.mapper")
@ImportResource(locations = {"classpath:applicationContext-biz.xml"})
public class CodingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingWebApplication.class, args);
    }

}
