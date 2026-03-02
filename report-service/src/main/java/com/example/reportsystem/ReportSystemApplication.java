package com.example.reportsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.reportsystem")
@SpringBootApplication
public class ReportSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportSystemApplication.class, args);
    }

}
