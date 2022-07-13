package com.woniuxy.smart_community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.woniuxy.smart_community.dao")
public class SmartCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCommunityApplication.class, args);
    }

}
