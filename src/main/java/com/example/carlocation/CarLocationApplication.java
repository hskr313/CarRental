package com.example.carlocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarLocationApplication.class, args);
    }

}
